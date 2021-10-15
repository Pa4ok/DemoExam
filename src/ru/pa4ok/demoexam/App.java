package ru.pa4ok.demoexam;

import java.util.*;

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
        - Set<Book> books
        - public boolean hasBook(Book book)
        - public boolean addBook(Book book)
        - public boolean removeBook(Book book)
     */

    public static void main(String[] args)
    {
        /*List<Book> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Book("title-" + i, "author-" + i, i * 10));
        }

        long mills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Book b = new Book("title-" + j, "author-" + j, j * 10);
                if(!list.contains(b)) {
                    list.add(b);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - mills) + "ms");*/

        /*Set<Book> set = new HashSet<>();
        set.add(new Book("1", "1", 1));
        set.add(new Book("2", "2", 2));
        set.add(new Book("1", "1", 1));
        System.out.println(set);
        System.out.println(set.contains(new Book("2", "2", 2)));
        System.out.println(set.contains(new Book("3", "2", 2)));
        System.out.println(set.remove(new Book("2", "2", 2)));
        System.out.println(set.remove(new Book("3", "2", 2)));
        System.out.println(set);

        for(Book b : set) {
            //...
        }*/

        Set<Book> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Book("title-" + i, "author-" + i, i * 10));
        }

        long mills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Book("title-" + j, "author-" + j, j * 10));
            }
        }

        System.out.println((System.currentTimeMillis() - mills) + "ms");
    }
}
