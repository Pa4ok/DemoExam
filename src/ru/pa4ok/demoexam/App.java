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
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Set> books
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
        /*Library lib = new Library(
                "grreegerrgger",
                new ArrayList<>(Arrays.asList(
                    new Book("t1", "a1", 10),
                        new Book("t2", "a2", 10),
                        new Book("t3", "a3", 10)
                ))
        );

        System.out.println(lib);
        System.out.println(lib.hasBook("t3", "a3"));
        System.out.println(lib.hasBook("t4", "a4"));
        System.out.println(lib.addBook("t4", "a4", 10));
        System.out.println(lib.addBook("t4", "a4", 10));
        System.out.println(lib.hasBook("t4", "a4"));
        System.out.println(lib.removeBook("t1", "a1"));
        System.out.println(lib.removeBook("t1", "a1"));
        System.out.println(lib);*/

        /*Book b1 = new Book("1", "1", 1);
        Book b2 = new Book("1", "1", 1);

        System.out.println(b1.equals(b2));*/

        /*List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("t1", "a1", 10),
                new Book("t2", "a2", 10),
                new Book("t3", "a3", 10)
        ));

        System.out.println(list);
        list.remove(new Book("t2", "a2", 10));
        System.out.println(list);*/

       /* Set<Book> set = new HashSet<>();
        set.add(new Book("t2", "a2", 10));
        set.add(new Book("t1", "a1", 10));
        set.add(new Book("t2", "a2", 10));
        System.out.println(set);*/

        /*Book b1 = new Book("t2", "a2", 10);
        Book b2 = new Book("t3", "a2", 10);

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());*/

        /*List<Book> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Book("title-" + i, "author-" + i, i));
        }

        long mills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Book b = new Book("title-" + i, "author-" + i, i);
                if(!list.contains(b)) {
                    list.add(b);

                }
            }
        }

        System.out.println(System.currentTimeMillis() - mills + "ms");*/

        /*Set<Book> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Book("title-" + i, "author-" + i, i));
        }

        long mills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Book("title-" + i, "author-" + i, i));
            }
        }

        System.out.println(System.currentTimeMillis() - mills + "ms");*/

        Set<Book> set = new HashSet<>();
        for(Book b : set) {
        }

        boolean b1 = set.add(new Book("1", "1", 1));
        boolean b2 = set.remove(new Book("1", "1", 1));
    }
}

