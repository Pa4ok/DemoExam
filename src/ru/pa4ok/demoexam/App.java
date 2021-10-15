package ru.pa4ok.demoexam;

import java.util.*;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */
public class App {
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


    public static void main(String[] args) {
        /*Library lib = new Library(
                "wpeofjpweofjew",
                new ArrayList<>(Arrays.asList(
                        new Book("title-1", "author-1", 10),
                        new Book("title-2", "author-2", 10),
                        new Book("title-3", "author-3", 10)
                )));

        System.out.println(lib);
        System.out.println();
        System.out.println(lib.hasBook("title-3", "author-3", 10));
        System.out.println(lib.hasBook("title-4", "author-3", 10));
        System.out.println();
        System.out.println(lib.addBook("title-4", "author-3", 10));
        System.out.println(lib.addBook("title-4", "author-3", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib);*/

        Map<String, Test> map = new HashMap<>();

        Test t1 = new Test("test1", 1);
        Test t2 = new Test("test2", 2);
        Test t3 = new Test("test3", 3);

        map.put(t1.title, t1);
        map.put(t2.title, t2);
        map.put(t3.title, t3);
        map.put(t1.title, t1);

        System.out.println(map);
        System.out.println(map.containsKey("test3"));
        System.out.println(map.containsKey("test4"));
        System.out.println(map.get("test3"));
        System.out.println(map.get("test4"));
        System.out.println(map.remove("test3"));
        System.out.println(map.remove("test3"));
        System.out.println(map);

        Set<String> keys = map.keySet();
        System.out.println(keys);

        List<Test> values = new ArrayList<>(map.values());
        System.out.println(values);

        Set<Map.Entry<String, Test>> entries = map.entrySet();
        for(Map.Entry<String, Test> e : entries) {
            System.out.println(e.getKey() + " | " + e.getValue());
        }

        //List<int> intList = new ArrayList<>();
        /*List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        System.out.println(intList);*/
    }
}

class Test {
    public String title;
    public int value;

    public Test(String title, int value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
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
}