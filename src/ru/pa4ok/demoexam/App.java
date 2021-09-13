package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            конструктор, переопределенный вывод (toString)
            все поля приватные + геттеры и сеттеры

            Book
            - String title
            - int pages

            Library
            - String address
            - Book[] books
            - public void addBook(Book book)

            метод addBook() должен перебирать массив с книгами
            если в нем есть пустой (null) элемент, то он должен на его место поставить книгу
            если в массиве нет ни 1 такого элемента, то вывести информацию в консоль
         */

        Book[] books = new Book[] {
                null,
                new Book("1", 1),
                new Book("2", 2),
                null,
                new Book("3", 3),
                new Book("4", 4)
        };

        Library lib = new Library("wdqdqwddwq", books);
        System.out.println(lib);
        lib.addBook(new Book("5", 5));
        lib.addBook(new Book("6", 6));
        lib.addBook(new Book("7", 7));
        System.out.println(lib);
    }
}

