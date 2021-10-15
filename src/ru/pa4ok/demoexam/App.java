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
        Library lib = new Library(
                "wfe;oefwefew",
                new HashSet<>(Arrays.asList(
                        new Book("1", "1", 1),
                        new Book("2", "2", 2),
                        new Book("3", "3", 3)
                )));

        lib.addBook(new Book("4", "4", 4));
        lib.getBooks().add(new Book("5", "5", 5));
    }
}
