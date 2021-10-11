package ru.pa4ok.demoexam;

import java.util.*;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
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
        - Set<Book> books
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author, int pages)
        - public boolean hasBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {

    }
}
