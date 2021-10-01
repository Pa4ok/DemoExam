package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App //
{
     /*
        Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - Book[] books
        - public void readBook() throws BookReadException, LibrarySpaceException
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - Book book
     */

    public static void main(String[] args)
    {
        Library lib = new Library(
                "owqidjopqiwd",
                new Book[] {
                        new Book("1", "1", 1),
                        null
                }
        );

        while(true)
        {
            try {
                System.out.println();
                lib.readBook();
            } catch (BookReadException e) {
                e.printStackTrace();
            } catch (LibrarySpaceException e) {
                System.out.println("В бибилиотеке кончилось место на книге: " + e.getBook());
                break;
            }
        }
    }
}
