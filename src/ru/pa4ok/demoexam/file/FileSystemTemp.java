package ru.pa4ok.demoexam.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileSystemTemp
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("text.txt");

        if(!Files.exists(path)) {
            Files.createFile(path);
        }

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
    }
}
