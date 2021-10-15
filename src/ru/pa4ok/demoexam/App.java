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
        - String title
        - String author
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
                new Book("a", "3", 3),
                new Book("c", "1", 1),
                new Book("b", "2", 2)
        ));

        //копия спика
        //List<Book> copy = new ArrayList<>(list);

        //Set<Book> set = new HashSet<>();
        //List<Book> copy = new ArrayList<>(set);

        System.out.println(list);

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                *//*
                    -1: o1 < o2
                     0: o1 = o2
                     1: o1 > o2
                 *//*
                if(o1.getPages() > o2.getPages()) {
                    return 1;
                }
                if(o1.getPages() < o2.getPages()) {
                    return -1;
                }
                return 0;
            }
        });*/

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getPages(), o2.getPages());
            }
        });*/

        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        //то же самое что и выше
        //Collections.sort(list, (o1, o2) -> Integer.compare(o1.getPages(), o2.getPages()));

        //снова то же самое что и выше
        //Collections.sort(list, Comparator.comparingInt(Book::getPages));

        System.out.println(list);


    }
}
