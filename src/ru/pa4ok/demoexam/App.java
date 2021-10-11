package ru.pa4ok.demoexam;

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
        /*Map<String, Test> map = new HashMap<>();

        Test t1 = new Test("title-1");
        Test t2 = new Test("title-2");
        Test t3 = new Test("title-3");

        map.put(t1.title, t1);
        Test t = map.get("rfrggegre");
        boolean b1 = map.containsKey("tterewtr");
        boolean b2 = map.containsValue(t2);
        map.remove(t3);

        Set<String> keys = map.keySet();
        System.out.println(keys);

        List<Test> values = new ArrayList<>(map.values());
        System.out.println(values);

        Set<Map.Entry<String, Test>> entries = map.entrySet();
        for(Map.Entry<String, Test> e : entries) {
            String key = e.getKey();
            Test value = e.getValue();
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(8);

    }
}

class Test
{
    public String title;
    public int a;
    public int b;

    public Test(String title) {
        this.title = title;
        Random rand = new Random();
        a = rand.nextInt(1000);
        b = rand.nextInt(1000);
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return a == test.a && b == test.b && Objects.equals(title, test.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, a, b);
    }
}
