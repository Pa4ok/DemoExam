package ru.pa4ok.demoexam;

import java.util.*;

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
        - int id
        - String title
        - String author
        - ing pages

        Library
        - String address
        - Set<Book> books
        - Map<Integer, Book> bookIdCache //ключ - id книги, объект - сама книга

        - public boolean addBook(Book book)
        - public boolean hasBook(Book book)
        - public boolean removeBook(Book book)

        - public Book addBook(int id, String title, String author, int pages)
        - public Book hasBook(int bookId)
        - public Book removeBook(int bookId)

        при добавлении или удалении книги из библиотеки необходимо обновлять bookIdCache

        методы которые принимают объект возрают true/false если они смогли найти/добавить/удалить такую книгу

        методы которые принимают поля книги/ее id, возврают саму книгу, если они ее нашли/добавали/удалили
        если не смогли - возрашают null
     */

    public static void main(String[] args)
    {
        Library lib = new Library("grreegerrgger");
        lib.
    }
}

