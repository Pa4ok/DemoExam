package ru.pa4ok.demoexam;

import java.util.*;

public class App
{
    /*
        Book
        - int id
        - String author
        - String title
        - ing pages

        Library
        - String address
        - Set<Book> books
        - Map<Integer, Book> bookIdCache //ключ - id книги, объект - сама книга

        - public boolean addBook(Book book)
        - public boolean hasBook(Book book)
        - public boolean removeBook(Book book)

        - public Book addBook(int id, String title, String author, int pages)
        - public Book hasBook(int bookId)
        - public Book removeBook(int bookId)

        при добавлении или удалении книги из библиотеки необходимо обновлять bookIdCache

        методы которые принимают объект возрают true/false если они смогли найти/добавить/удалить такую книгу

        методы которые принимают поля книги/ее id, возврают саму книгу, если они ее нашли/добавали/удалили
        если не смогли - возрашают null
     */

    public static void main(String[] args)
    {
        /*Map<String, String> map = new HashMap<>();
        map.put("testkey1", "testvalue1");
        map.put("testkey2", "testvalue2");
        System.out.println(map);
        //System.out.println(map.get("testkey2"));
        //System.out.println(map.get("pwefjipwefwei"));

        //все значения
        List<String> values = new ArrayList<>(map.values());
        System.out.println(values);

        //все ключи
        //List<String> keys = new ArrayList<>(map.keySet());
        Set<String> keys = new HashSet<>(map.keySet());
        System.out.println(keys);

        //Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("ключ: " + entry.getKey() + " | " + "значение: " + entry.getValue());
        }*/
    }
}
