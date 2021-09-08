package ru.pa4ok.demoexam;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.Arrays;
import java.util.GregorianCalendar;
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
        все поля в классах приватные + геттеры и сеттеры
        +конструктор на все поля и переопределенный вывод (toString)

        class Book
        - String title
        - String author
        - int pages

        class Library
        - String address
        - Book[] books
        - public boolean addBook(Book book)
        - public boolean removeBook(String title)

        //при добавлении вы ищите null элемент в массиве books
        //если такой элемент имеется, то ставите книгу на его место
        //если получилось добавить - возвращаете true, если нет - false
        //при удалении ищете книгу с таким же названием, если нашли то заменили на null
        //если получилось удалить - возвращаете true, если нет - false

     */

    public static void main(String[] args)
    {
        /*Book book = new Book("2fewfew312", "wefwefewf", 222);
        System.out.println(book);*/

        Book[] books = new Book[] {
                new Book("2fewfew312", "2efwefewf", 222),
                null,
                null
        };

        Library lib = new Library("owefgoifg", books);
        System.out.println(lib);

        System.out.println(lib.addBook(new Book("1", "2", 3)));
        System.out.println(lib.addBook(new Book("2", "2", 3)));
        System.out.println(lib.addBook(new Book("3", "2", 3)));
        System.out.println(lib);
        System.out.println(lib.removeBook("3"));
        System.out.println(lib.removeBook("2"));
        System.out.println(lib);
    }
}
