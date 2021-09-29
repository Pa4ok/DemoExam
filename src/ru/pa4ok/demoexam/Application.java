package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
        ru.pa4ok.demoexam.Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - ru.pa4ok.demoexam.Book[] books
        - public void readBook()
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - ru.pa4ok.demoexam.Book book
     */

    public static void main(String[] args)
    {
        Library lib = new Library("wqdweqfferwfe", new Book[] {
                new Book("b1", "a1", 100),
                null,
                new Book("b2", "a2", 100),
        });

        try {
            lib.readBook();
            lib.readBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
