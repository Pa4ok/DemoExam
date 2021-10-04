package ru.pa4ok.demoexam;

import java.util.Scanner;

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
                "edfpiewfjoweiffew",
                new Book[]{
                        new Book("t1", "a1", 100),
                        null
                }
        );

        System.out.println(lib);

        while(true)
        {
            try {
                lib.readBook();
            } catch (BookReadException e) {
                e.printStackTrace();
            } catch (LibrarySpaceException e) {
                e.printStackTrace();
                System.out.println("книге " + e.getBook() + " не хватило места") ;
                break;
            }
        }

        System.out.println(lib);
    }
}

