package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

        Book
        - String title
        - String author
        - int pages

        Library
        - String address
        - Book[] books
        - public void addBook(Book book)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        если в массиве нет null элментов, то выводите что нибудь в консоль
     */

    public static void main(String[] args)
    {
        Book[] books = new Book[] {
                new Book("1", "1", 1),
                null,
                new Book("2", "2", 2),
                null,
                new Book("3", "3", 3)
        };

        Library lib = new Library("dpqwoojdqwodj", books);
        System.out.println(lib);
        lib.addBook(new Book("4", "4", 4));
        lib.addBook(new Book("5", "5", 5));
        lib.addBook(new Book("6", "6", 6));
        System.out.println(lib);
    }
}
