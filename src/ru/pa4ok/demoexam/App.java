package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

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
        - public boolean addBook(Book book)
        - public boolean removeBook(String title, String author)

        при попытке доабвления книги вы ищете null элемент в массиве books
        если такой есть - ставить новую книгу на его месте и возвращаете true, если нет - false
        при удалении вы ищите не null элемент массива где будут совпадать title и author
        если такой есть ставите на его место null и возвращаете true, если нет - false

     */

    public static void main(String[] args)
    {
        Library lib = new Library("dqwdqwdqw", new Book[] {
                new Book("1", "1", 10),
                new Book("2", "2", 10),
                null
        });

        System.out.println(lib);
        System.out.println(lib.addBook(new Book("3", "3", 10)));
        System.out.println(lib.addBook(new Book("4", "4", 10)));
        System.out.println(lib);
        System.out.println(lib.removeBook("3", "3"));
        System.out.println(lib.removeBook("4", "4"));
        System.out.println(lib.removeBook("1", "1"));
        System.out.println(lib);


    }
}
