package ru.pa4ok.demoexam;

import java.util.*;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
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
        Map<String, Test> map = new HashMap<>();

        Test t1 = new Test("1", 1);
        Test t2 = new Test("2", 2);
        Test t3 = new Test("1", 3);

        map.put(t1.title, t1);
        map.put(t2.title, t2);
        System.out.println(map);
        /*map.put(t3.title, t3);
        System.out.println(map);
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsKey("3"));
        System.out.println(map.get("2"));
        System.out.println(map.remove("2"));
        System.out.println(map.remove("2"));*/

        System.out.println();

        Set<String> keys = map.keySet();
        System.out.println(keys);

        System.out.println();

        List<Test> values = new ArrayList<>(map.values());
        System.out.println(values);

        System.out.println();

        Set<Map.Entry<String, Test>> entries = map.entrySet();
        for(Map.Entry<String, Test> e : entries) {
            System.out.println(e.getKey() + " | " + e.getValue());
        }

        //List<int> list = new ArrayList<>();
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        System.out.println(list);*/
    }
}

class Test
{
    public String title;
    public int value;

    public Test(String title, int value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return value == test.value && Objects.equals(title, test.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, value);
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }
}
