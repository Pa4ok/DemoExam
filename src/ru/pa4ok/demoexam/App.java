package ru.pa4ok.demoexam;

import java.util.*;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class App
{
    /*
        Book
        - int id
        - String title
        - String author
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
        /*Library lib = new Library(
                "grreegerrgger",
                new HashSet<>(Arrays.asList(
                    new Book("t1", "a1", 10),
                        new Book("t2", "a2", 10),
                        new Book("t3", "a3", 10)
                ))
        );

        System.out.println(lib);
        System.out.println(lib.hasBook("t3", "a3", 10));
        System.out.println(lib.hasBook("t4", "a4", 10));
        System.out.println(lib.addBook("t4", "a4", 10));
        System.out.println(lib.addBook("t4", "a4", 10));
        System.out.println(lib.hasBook("t4", "a4", 10));
        System.out.println(lib.removeBook("t1", "a1", 10));
        System.out.println(lib.removeBook("t1", "a1", 10));
        System.out.println(lib);*/



        Map<String, Test> map = new HashMap<>();

        Test t1 = new Test("test1", 44.54345, 44);
        Test t2 = new Test("test2", 45.54345, 45);
        Test t3 = new Test("test3", 46.54345, 46);

        map.put(t1.title, t1);
        map.put(t2.title, t2);
        map.put(t3.title, t3);

        /*System.out.println(map);
        System.out.println(map.get("test1"));
        System.out.println(map.get("test4"));
        System.out.println(map.containsKey("test1"));
        System.out.println(map.containsKey("test4"));
        System.out.println(map.remove("test1"));
        System.out.println(map.remove("test4"));
        System.out.println(map.remove("test2", t3));
        System.out.println(map);*/

        System.out.println(map);
        System.out.println();

        Set<String> keys = map.keySet();
        System.out.println(keys);
        System.out.println();

        List<Test> values = new ArrayList<>(map.values());
        System.out.println(values);
        System.out.println();

        Set<Map.Entry<String, Test>> entries = map.entrySet();
        for(Map.Entry<String, Test> e : entries) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println();
    }
}

class Test
{
    public String title;
    public double value1;
    public int value2;

    public Test(String title, double value1, int value2) {
        this.title = title;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}

