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
import java.util.Arrays;
import java.util.List;

/**
 * gson lib: com.google.code.gson:gson:2.9.0
 */
public class FileSystemTest
{
    /*
        считать файл users.json
        создать все необходимые классы для десериализации списка пользователей
        получить список пользователей через gson
        изменить в списке несколько произвольных элементов
        сохранить измененный список обратно в файл
     */
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("text.txt");

        /*if(!Files.exists(path)) {
            Files.createFile(path);
        }*/

        /*String text = Files.readString(path);
        System.out.println(text);*/

        /*List<String> lines = Files.readAllLines(path);
        for(int i=0; i<lines.size(); i++) {
            String s = lines.get(i);
            s += "_new";
            lines.set(i, s);
        }
        Files.write(path, lines);*/
        //StandardOpenOption

        //List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
        //List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        //Files.delete(path);

        /*Files.copy(
                Paths.get("text.txt"),
                Paths.get("text-copy.txt")
        );*/
        //StandardCopyOption

        /*Human human = new Human("vasya", 15, Arrays.asList("123", "321", "abc"));
        Gson gson = new Gson();
        String json = gson.toJson(human);
        System.out.println(json);*/

        /*String json = Files.readString(Paths.get("vasya.json"));
        Gson gson = new Gson();
        Human human = gson.fromJson(json, Human.class);
        System.out.println(human);*/

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        Gson gson = builder.create();

        Human human = new Human(null, 15, Arrays.asList(new Hobby("123", 100), new Hobby("321", 200)));
        String json = gson.toJson(human);
        Files.writeString(Paths.get("vasya.json"), json);

        /*String json = Files.readString(Paths.get("posts.json"));
        List<Post> posts = gson.fromJson(json, TypeToken.getParameterized(List.class, Post.class).getType());
        for(Post p : posts) {
            System.out.println(p);
            System.out.println();
        }*/
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
