package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
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
        - public void addBook(Book b)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        если в массиве нет null элментов, то выводите что нибудь в консоль
     */
    
    public static void main(String[] args)
    {
        Library lib = new Library(
                "we;fjhewoifew",
                new Book[]{
                        null,
                        new Book("book1", "author1", 100),
                        new Book("book2", "author2", 100),
                        null,
                        new Book("book3", "author3", 100),
                        new Book("book4", "author4", 100),
                        new Book("book5", "author5", 100)
                }
        );
        System.out.println(lib);
        lib.addBook(new Book("book5", "author5", 100));
        lib.addBook(new Book("book6", "author6", 100));
        lib.addBook(new Book("book7", "author7", 100));
        System.out.println(lib);
    }
}

