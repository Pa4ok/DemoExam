package ru.pa4ok.demoexam.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * gson lib: com.google.code.gson:gson:2.9.0
 */
public class FileSystemTemp
{
    /*
        считать файл users.json
        создать все необходимые для десериализации классы
        десереализовать список пользоавтелей
        поменять несколько произвольных полей/удалить каких-то пользователей
        сериализовать список обратно в json и записать в тот же файл
     */
    public static void main(String[] args) throws IOException
    {
        /*Path path = Paths.get("text.txt");

        if(!Files.exists(path)) {
            Files.createFile(path);
        }*/

        /*String s = Files.readString(path);
        System.out.println(s);*/

        /*String s = "112pijegfhth34\noiwefghiweofhewug\nopiewfhhiewf";
        Files.writeString(path, s);*/

        /*List<String> lines = Files.readAllLines(path);
        for(int i=0; i<lines.size(); i++) {
            String s = lines.get(i);
            lines.set(i, s + "_new");
        }
        Files.write(path, lines);*/
        //StandardOpenOption

        //String s = Files.readString(path, Charset.forName("UTF-8"));
        //String s = Files.readString(path, StandardCharsets.UTF_8);

        /*Files.copy(
                Paths.get("text.txt"),
                Paths.get("text-copy.txt")
        );*/
        //StandardCopyOption

        //Files.delete(path);

        //Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        Gson gson = builder.create();

        /*Human human = new Human(null, 15, Arrays.asList(new Hobby("123", 100), new Hobby("321", 200)));
        String json = gson.toJson(human);
        Files.writeString(Paths.get("vasya.json"), json);*/

        /*String json = Files.readString(Paths.get("vasya.json"));
        Human human = gson.fromJson(json, Human.class);
        System.out.println(human);*/

        /*List<Human> humans = new ArrayList<>();
        humans.add(new Human(null, 15, Arrays.asList(new Hobby("123", 100), new Hobby("321", 200))));
        humans.add(new Human(null, 15, Arrays.asList(new Hobby("123", 100), new Hobby("321", 200))));
        humans.add(new Human(null, 15, Arrays.asList(new Hobby("123", 100), new Hobby("321", 200))));
        Files.writeString(Paths.get("vasya-list.json"), gson.toJson(humans));*/

        String json = Files.readString(Paths.get("vasya-list.json"));
        List<Human> humans = gson.fromJson(json, TypeToken.getParameterized(List.class, Human.class).getType());
        System.out.println(humans);
    }
}

@Data
@AllArgsConstructor
class Human
{
    private String name;
    private int age;
    private List<Hobby> hobbies;
}

@Data
@AllArgsConstructor
class Hobby
{
    private String title;
    private double cost;
}
