import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("./users.json");

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        Gson gson = builder.create();

        String json = Files.readString(path);
        List<User> users = gson.fromJson(json, TypeToken.getParameterized(List.class, User.class).getType());

        for(User u : users) {
            u.setEmail("vasya@gmail.com");
            u.getCompany().setName("fspo");
        }

        json = gson.toJson(users);
        Files.writeString(path, json);
    }
}

@Data
@AllArgsConstructor
class User
{
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}

@Data
@AllArgsConstructor
class Address
{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}

@Data
@AllArgsConstructor
class Geo
{
    private double lat;
    private double lng;
}

@Data
@AllArgsConstructor
class Company
{
    private String name;
    private String catchPhrase;
    private String bs;
}
