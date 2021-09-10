package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 */

public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

        Book
        - String title
        - String author
        - int pages

        Library
        - String address
        - Book[] books
        - public void addBook(Book book)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        если в массиве нет null элментов, то выводите что нибудь в консоль
     */

    public static void main(String[] args)
    {
        /*Book[] arr = new Book[3];
        arr[1] = new Book("1", "1", 10);
        */

        Book[] books = new Book[] {
                null,
                new Book("1", "1", 10),
                null
        };

        Library lib = new Library("wefokewkfopwef", books);
        System.out.println(lib);
        lib.addBook(new Book("2", "2", 10));
        lib.addBook(new Book("3", "3", 10));
        lib.addBook(new Book("4", "4", 10));
        System.out.println(lib);

    }
}
