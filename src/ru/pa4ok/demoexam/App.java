package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

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
        /*Book b1 = new Book("title1", "author1", 10);
        Book b2 = new Book("title2", "author2", 10);
        Book b3 = new Book("title3", "author3", 10);

        Map<String, Book> map = new HashMap<>();
        map.put(b1.getTitle(), b1);
        map.put(b2.getTitle(), b2);
        map.put(b3.getTitle(), b3);
        System.out.println(map);

        System.out.println(map.get("title4"));
        System.out.println(map.get("title2"));

        Set<String> keys = map.keySet();
        System.out.println(keys);

        List<Book> values = new ArrayList<>(map.values());
        System.out.println(values);

        Set<Map.Entry<String, Book>> entries = map.entrySet();
        for(Map.Entry<String, Book> e : entries) {
            System.out.println(e.getKey() + " | " + e.getValue());
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(3);
   }
}