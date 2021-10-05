package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
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
        - public Book removeBook(String title, String author, int pages)
        - public boolean hasBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        /*Container c1 = new Container("123412321");
        Container c2 = new Container(new Book("wefewfew"));*/

        /*Container<String> c1 = new Container<>("ewfwefew");
        String s = c1.value;

        Container<Book> c2 = new Container<>(new Book("wefewfew"));
        Book b = c2.value;*/

        /*List<String> list = new ArrayList<>();
        list.add("oqidiqwdqwd");
        list.add("tyjytj");
        list.add("jtjy");
        list.add("ewfd");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);*/

        List<String> list = new ArrayList<>(Arrays.asList(
            "1", "22", "3", "44", "55", "66", "7", "88", "9"
        ));

        System.out.println(list);

        /*for(int i=0; i<list.size(); i++) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        /*for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        //list.removeIf(s -> s.length() > 1);

        /*for(String s : list) {
        }*/
        test(list);

        System.out.println(list);
    }

    public static void test(List<String> list) {
        list.add("123");
    }
}

class Container<T>
{
    public T value;

    public Container(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Container{" +
                "value=" + value +
                '}';
    }
}

class Book
{
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