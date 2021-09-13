package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
        конструктор на все поля + toString
        все поля приватные + геттеры и сеттеры

        Book
        - String title
        - int pages

        Library
        - String address
        - Book[] books
        - public void addBook(Book book)

        в методе addBook вы перебираете элементы массива
        и ищите null элемент, если таковой есть - ставите на его место
        книгу, которая пришла в аргументах
         */

        Book[] books = new Book[] {
                null,
                new Book("1", 1),
                null,
                new Book("2", 2),
                new Book("3", 3)
        };

        Library lib = new Library("wqadqw[odiqwd", books);
        System.out.println(lib);
        lib.addBook(new Book("4", 4));
        lib.addBook(new Book("5", 5));
        lib.addBook(new Book("6", 6));
        System.out.println(lib);
    }
}

