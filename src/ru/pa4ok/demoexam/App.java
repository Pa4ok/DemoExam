package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;
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
        - String title
        - String author
        - ing pages

        Library
        - String address
        - Set<Book> books
        - public boolean hasBook(String title, String author, int pages)
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        /*Library lib = new Library(
                "wefpiewrifgjwe",
                new ArrayList<>(Arrays.asList(
                        new Book("title-1", "author-1", 10),
                        new Book("title-2", "author-2", 10)
                ))
        );

        System.out.println(lib);
        System.out.println(lib.hasBook("title-2", "author-2", 10));
        System.out.println(lib.hasBook("title-3", "author-3", 10));
        System.out.println(lib.addBook("title-3", "author-3", 10));
        System.out.println(lib.addBook("title-3", "author-3", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib);*/

        /*Book b1 = new Book("title", "author", 10);
        Book b2 = new Book("title", "author", 10);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));*/

        /*List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("title-1", "author-1", 10),
                new Book("title-2", "author-2", 10)
        ));

        System.out.println(list);
        //list.remove(new Book("title-1", "author-1", 10));
        //System.out.println(list.indexOf(new Book("title-1", "author-1", 10)));
        //System.out.println(list.indexOf(new Book("ewfweflknewfoew-1", "author-1", 10)));
        System.out.println(list.contains(new Book("title-1", "author-1", 10)));
        System.out.println(list.contains(new Book("wefwefwefwef-1", "author-1", 10)));
        System.out.println(list);*/

        Set<Book> set = new HashSet<>();
        //set.add(new Book("t1", "a1", 10));
        set.add(new Book("1t2wefwefew", "a2", 10));
        set.add(new Book("trthy1", "a1", 10));
        set.add(new Book("juy6ytujyt65yt1", "a1", 10));
        set.add(new Book("442", "a1", 10));
        System.out.println(set);

        for(Book b : set) {
            //...
        }

        set.removeIf(book -> book.getPages() < 50);

        /*List<Book> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Book("title-1", "auhtor-1", i*10));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Book b = new Book("title-1", "auhtor-1", i*10);
                if(!list.contains(b)) {
                    list.add(b);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");*/

        /*Set<Book> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Book("title-1", "auhtor-1", i*10));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Book("title-1", "auhtor-1", i*10));
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");*/
    }
}