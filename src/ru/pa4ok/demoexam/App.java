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

    public static void main(String[] args)
    {
        Library lib = new Library(
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
        System.out.println(lib);
    }
}

