package ru.pa4ok.demoexam.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class FileSystemTest
{
    /*
        реализовать кнопку экспорта данных из таблицы в файл
        по нажатию кнопки только отображаемые в данный момент записи
        должны быть записаны в файл content.txt (1 запись = 1 строка)
        можно взять мою таблицу с гита, можно любую вашу работу
        при приведении записи к строке просто записать основные данные
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
    }
}
