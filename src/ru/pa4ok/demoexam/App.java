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

        /*Book b1 = new Book("title-1", "author-1", 10);
        Book b2 = new Book("title-1", "author-1", 10);

        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));*/

        /*List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("title-1", "author-1", 10),
                new Book("title-2", "author-2", 10),
                new Book("title-3", "author-3", 10)
        ));

        System.out.println(list);
        list.remove(new Book("title-2", "author-2", 10));
        System.out.println(list);
        System.out.println(list.contains(new Book("title-3", "author-3", 10)));
        System.out.println(list.contains(new Book("title-4", "author-3", 10)));
        System.out.println(list.indexOf(new Book("title-3", "author-3", 10)));
        System.out.println(list.indexOf(new Book("title-4", "author-3", 10)));*/

        /*List<Book> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Book("title-" + i, "author-" + i, i * 10));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Book b = new Book("title-" + j, "author-" + j, j * 10);
                if(!list.contains(b)) {
                    list.add(b);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");*/

        /*Set<Book> set = new HashSet<>();
        set.add(new Book("fqwfewef-3", "author-3", 10));
        set.add(new Book("tiwefweftle-2", "author-2", 10));
        set.add(new Book("jyttyjtle-1", "author-1", 10));
        System.out.println(set);
        set.remove(new Book("tiwefweftle-2", "author-2", 10));
        System.out.println(set);

        for(Book b : set) {
            //...
        }*/

        Set<Book> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Book("title-" + i, "author-" + i, i * 10));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Book("title-" + j, "author-" + j, j * 10));
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");
    }
}
