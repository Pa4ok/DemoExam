package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
 */

public class App
{
    /*
        Book
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Book> books
        - public boolean hasBook(String title, String author, int pages)
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги
        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее
        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        Library lib = new Library(
                "we;lfjweopfgwef",
                new ArrayList<>(Arrays.asList(
                        new Book("t1", "a1", 10),
                        new Book("t2", "a2", 10),
                        new Book("t3", "a3", 10)
                        ))
        );

        System.out.println(lib);
        lib.addBook("12312e", "321423432", 44);
        System.out.println(lib);
    }
}


