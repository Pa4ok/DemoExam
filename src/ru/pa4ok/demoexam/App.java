package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - Book[] books
        - public void readBook()
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends RuntimeException

        LibrarySpaceException extends Exception
        - Book book
     */

    public static void main(String[] args)
    {
        Library lib = new Library(
                "eqwdijqidjdwq",
                new Book[]{
                    new Book("t1", "a1", 100),
                        new Book("t2", "a2", 100),
                        new Book("t3", "a3", 100),
                        new Book("t4", "a4", 100)
                }
        );

        System.out.println(lib);

        try {
            lib.readBook();
        } catch (LibrarySpaceException e) {
            System.out.println("Книге не хватило места: " + e.getBook());
        }

        System.out.println(lib);
    }
}
