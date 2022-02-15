package ru.pa4ok.demoexam.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gson lib: com.google.code.gson:gson:2.9.0
 */
public class FileSystemTest
{
    /*
        user.json
        создать классы необходимые для описанея структуры в файле
        считать файл и отпрасить его через gson
        произвольно поменять несколько полей и сохранить измененную версию файла
     */

    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("./text.txt");

        /*if(!Files.exists(path)) {
            Files.createFile(path);
        }*/

        /*List<String> lines = Files.readAllLines(path);
        System.out.println(lines);

        for(int i=0; i<lines.size(); i++) {
            String s = lines.get(i);
            lines.set(i, s + "_new");
        }

        Files.write(path, lines);*/
        //StandardOpenOption

        //Files.writeString(Paths.get("text_new.txt"), "testString");

        /*Files.copy(
                Paths.get("./text.txt"),
                Paths.get("./text-copy.txt")
        );*/
        //StandardCopyOption

        //Files.delete(Paths.get("./text_new.txt"));

        //List<String> linesUtf8 = Files.readAllLines(path, Charset.forName("UTF-8"));
        //List<String> linesUtf8 = Files.readAllLines(path, StandardCharsets.UTF_8);

        /*Human human = new Human("Vasya", 15, Arrays.asList("one", "two", "three"));
        Gson gson = new Gson();
        String s = gson.toJson(human);
        System.out.println(s);*/

        /*String s = Files.readString(Paths.get("./vasya.json"));
        Gson gson = new Gson();
        Human human = gson.fromJson(s, Human.class);
        System.out.println(human);*/

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        builder.enableComplexMapKeySerialization();
        Gson gson = builder.create();

        /*Human human = new Human(null, 15, Arrays.asList("one", "two", "three"));
        String s = gson.toJson(human);
        System.out.println(s);*/

       /*Human h = new Human("vasya", 15, Arrays.asList("one", "two", "three"));
        Map<Human, String> map = new HashMap<>();
        map.put(h, "123");
        map.put(h, "456");
        map.put(h, "789");

        String s = gson.toJson(map);
        System.out.println(s);*/
    }
}

@Data
@AllArgsConstructor
class Human
{
    private String name;
    private int age;
    private List<String> list;
}

@Data
@AllArgsConstructor
class Config
{
    public boolean testEnable;
}
