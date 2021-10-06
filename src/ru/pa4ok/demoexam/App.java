package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - Book book
     */


    public static void main(String[] args)
    {
        Library lib = new Library(
                "wefwefpoiewfhwe",
                new Book[]{
                        null,
                        new Book("title1", "author1", 10),
                        null
                }
        );

        System.out.println(lib);

        while(true)
        {
            try {
                lib.readBook();
            } catch (BookReadException e) {
                System.out.println("ошибка чтения книги");
                e.printStackTrace();
            } catch (LibrarySpaceException e) {
                System.out.println("место кончилось на книге: " + e.getBook());
                break;
            }
        }
    }
}
