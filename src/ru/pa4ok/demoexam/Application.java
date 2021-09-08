package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
            пока что во всех наших классах все поля будут приватными
            +должны быть публичные геттеры и сеттеры для взаимодействия с ними

            Book
            - String title
            - String author
            - int page

            Library
            - String address
            - Book[] books
            - public boolean addBook(Book book)
            - public boolean removeBook(String title, String author)

            при создании объекта Library в инициализирует массив books с какой-то заданной длиной
            при попытке доабвления книги вы ищете null элемент в массиве books
            если такой есть - ставить новую книгу на его месте и возвращаете true, если нет - false
            при удалении вы ищите не null элемент массива где будут совпадать title и author
            если такой есть ставите на его место null и возвращаете true, если нет - false

     */

    public static void main(String[] args)
    {
        Book[] books = new Book[] {
                new Book("1", "1", 1),
                null,
                new Book("2", "2", 2),
                null,
                new Book("3", "3", 3),
                new Book("4", "4", 4)
        };

        Library library = new Library("addrwgihrig", books);
        System.out.println(library);

        /*System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));*/

        System.out.println(library.removeBook("1", "2"));
        System.out.println(library);
        System.out.println(library.removeBook("3", "3"));
        System.out.println(library);
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library);
        System.out.println(library.addBook(new Book("ewfgweoif", "ewfwef", 323)));
        System.out.println(library);
    }
}