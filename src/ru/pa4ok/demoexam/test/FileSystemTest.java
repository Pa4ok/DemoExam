package ru.pa4ok.demoexam.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

/**
 * gson lib: com.google.code.gson:gson:2.9.0
 */
public class FileSystemTest
{
    /*
        создать все необходимые для десераиализации users.json классы
        считать файл и отредактировать произвольные поля у пользователей
        записать измененный список пользователей обратно
     */
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("./text.txt");

        /*if(!Files.exists(path)) {
            Files.createFile(path);
        }

        List<String> lines = Files.readAllLines(path);
        System.out.println(lines);

        for(int i=0; i<lines.size(); i++) {
            String s = lines.get(i);
            s += "_new";
            lines.set(i, s);
        }
        System.out.println(lines);
        Files.write(path, lines);*/
        //StandardOpenOption

        /*String s = Files.readString(path);
        System.out.println(s);
        s = "123";
        Files.writeString(path, s);*/

        /*if(Files.exists(path)) {
            Files.delete(path);
        }*/

        //String uft8 = Files.readString(path, Charset.forName("UTF-8"));
        //String uft8 = Files.readString(path, StandardCharsets.UTF_8);

        /*Files.copy(
                Paths.get("text.txt"),
                Paths.get("text-copy.txt")
        );*/
        //StandardCopyOption

        //Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        Gson gson = builder.create();

        /*Human human = new Human(null, 15, Arrays.asList(new Hobby("grrw", 100), new Hobby("regerg", 200)));
        String json = gson.toJson(human);
        Files.writeString(Paths.get("vasya.json"), json);
        System.out.println(json);*/

        /*String json = Files.readString(Paths.get("vasya.json"));
        Human human = gson.fromJson(json, Human.class);
        System.out.println(human);*/

        String json = Files.readString(Paths.get("posts.json"));
        List<Post> posts = gson.fromJson(json, TypeToken.getParameterized(List.class, Post.class).getType());
        System.out.println(posts);
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

@Data
@AllArgsConstructor
class Post
{
    private int userId;
    private int id;
    private String title;
    private String body;
}