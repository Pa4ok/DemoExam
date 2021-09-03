package ru.pa4ok.demoexam;

import java.util.Random;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * cntl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    public static void main(String[] args)
    {
        /*
            class Book +конструктор со всеми полями
            - String title
            - String author
            - int pages

            создать объект класса Book

            создать статичную функцию в главном классе
            которая будет принимать книгу и рандомно менять в ней количество страниц

            +вывод полей книги до и после
         */
        Book book = new Book("ewfoiwefowe", "ewfewffewwef", 222);
        book.print();
        randPagesCount(book);
        book.print();
    }

    public static void randPagesCount(Book book)
    {
        Random rand = new Random();
        book.pages = rand.nextInt(1000);
    }
}

class Book
{
    String title;
    String author;
    int pages;

    public Book(String title, String author, int pages)
    {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void print()
    {
        System.out.println("MyBook: " + title + " " + author + " " + pages);
    }
}
