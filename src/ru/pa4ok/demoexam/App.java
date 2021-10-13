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
        - String author
        - String title
        - ing pages

        Library
        - String address
        - Set<Book> books
        - public List<Book> getSortedById()
        - public List<Book> getSortedByTitle()
        - public List<Book> getSortedByPages()
        - public List<Book> getAuthorBooks(String author)

     */

    public static void main(String[] args)
    {
        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book(2, "b", "2", 2),
                new Book(1, "c", "2", 2),
                new Book(3, "a", "2", 2)
        ));

        System.out.println(list);

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                *//*
                    -1: o1 <  o2
                     0: o1 == o2
                     1: o1 >  o2
                 *//*
                if(o1.getId() > o2.getId()) {
                    return 1;
                }
                if(o1.getId() < o2.getId()) {
                    return -1;
                }
                return 0;
            }
        });*/

        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });*/

        //тоже самое что и наверху
        //Collections.sort(list, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

        System.out.println(list);

        //List<Book> copy = new ArrayList<>(list);
    }
}

