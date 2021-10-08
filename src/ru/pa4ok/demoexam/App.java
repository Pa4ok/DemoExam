package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App //
{
    /*
        Book
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Book> books
        - public boolean hasBook(Book book)
        - public boolean addBook(Book book)
        - public boolean removeBook(Book book)
     */

    public static void main(String[] args)
    {
        /*Container c1 = new Container("wefwfwefew");
        Container c2 = new Container(new Book("t1", "a1", 10));

        String s = (String) c1.value;
        Book b = (Book) c2.value;*/

        /*Container<String> c1 = new Container<>("wefwfwefew");
        Container<Book> c2 = new Container<>(new Book("t1", "a1", 10));

        String s = c1.value;
        Book b = c2.value;*/

        /*List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(1, "abc");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());*/

        /*List<String> list = new ArrayList<>(Arrays.asList(
                "1","22","3","44","55","66","7","88","9"
        ));*/

        /*for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        /*for(String s : list) {
            System.out.println(s);
        }*/

        //System.out.println(list);

        /*for(int i=0; i<list.size(); i++) {
            if(list.get(i).length() > 1) {
                list.remove(i);
                i--;
            }
        }*/

        /*for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        //list.removeIf(s -> s.length() > 1);
        //System.out.println(list);

        /*Library lib = new Library(
                "weprigjpqwofqw",
                new ArrayList<>(Arrays.asList(
                        new Book("t1", "a1", 10)
                ))
        );

        System.out.println(lib);
        System.out.println(lib.hasBook("t1", "a1", 10));
        System.out.println(lib.hasBook("t2", "a2", 10));
        System.out.println(lib.addBook("t2", "a2", 10));
        System.out.println(lib.addBook("t2", "a2", 10));
        System.out.println(lib.addBook("t2", "a2", 10));
        System.out.println(lib.hasBook("t2", "a2", 10));
        System.out.println(lib.removeBook("t2", "a2", 10));
        System.out.println(lib.removeBook("t2", "a2", 10));
        System.out.println(lib);*/


        Book b2 = new Book("t2", "a2", 10);
        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("t1", "a1", 10),
                b2,
                new Book("t3", "a3", 10)
        ));

        //System.out.println(list.contains(b2));
        //System.out.println(list.contains(new Book("t2", "a2", 10)));
        /*System.out.println(list);
        System.out.println(list.remove(new Book("t2", "a2", 10)));
        System.out.println(list);

        */

        for(Book b : list) {
            System.out.println(b2.equals(b));
        }

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
