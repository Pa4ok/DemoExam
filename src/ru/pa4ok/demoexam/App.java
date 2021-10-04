package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Book> books
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author)
        - public boolean hasBook(String title, String author)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args) {
        /*Container<Book> c = new Container<>(new Book("werkweofhew"));
        System.out.println(c.value.title);*/

        /*List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(0, "aaaa");
        System.out.println(list);
        System.out.println(list.contains("one"));
        System.out.println(list.contains("two"));
        System.out.println(list.remove("two"));
        System.out.println(list.remove(1));
        System.out.println(list.size());
        System.out.println(list);
        test(list);
        System.out.println(list);*/

        List<String> list = new ArrayList<>(Arrays.asList(
                "1", "22", "3", "44", "55", "55", "5", "66", "7"
        ));

        System.out.println(list);

        /*for(int i=0; i<list.size(); i++) {
            String s = list.get(i);
            if(s.length() > 1) {
                list.remove(i);
            }
        }*/
        /*for(int i=list.size()-1; i>=0; i--) {
            String s = list.get(i);
            if(s.length() > 1) {
                list.remove(i);
            }
        }*/

        //list.removeIf(s -> s.length() > 1);

        /*for(String s : list) {
            if(s.length() > 1) {
                list.remove(s);
            }
        }*/

        System.out.println(list);

        /*for(String s : list) {
            //...
        }*/


        /*System.out.println(list);
        list.add("1");
        System.out.println(list);

        Test t = new Test();
        t.getList().add("123");
        t.getList().add("123");*/

        String s1 = "12ewfef";
        String s2 = "12ewfef";
        boolean b = s1.equals(s2);
    }


    public static void test(List<String> list) {
        list.add("123");
    }
}

class Container<T> {
    public T value;

    public Container(T value) {
        this.value = value;
    }

    public void test() {
        if (value instanceof Book) {
            Book b = (Book) value;
        }
    }

    @Override
    public String toString() {
        return "Container{" +
                "value=" + value +
                '}';
    }
}

class Book {
    public String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}

class Test {
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }
}