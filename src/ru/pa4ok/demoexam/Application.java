package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - вызов контекстного меню по исправлению ошибки
 * cntl + space - вызов контекстного меню с доступными методами и полями объекта (после точки)
 */

public class Application
{
    public static void main(String[] args)
    {
        Book book = new Book("my title 1", 321);

        /*System.out.println(book);
        book.print();

        Book book1 = new Book("second book");
        book1.print();*/

        book.print();
        test(book);
        book.print();

        /*
            class House + конструктор со всеми полями
            - String address
            - int floors
            - int humanCount
            - public void print() выводит все 3 поля объекта

            в main функции нужно создать объет класса House

            в главном классе нужно разместить 2 функции: addHuman, removeHuman
            они будут принимать в аргументах объект класса House и увеличивать/уменьшать количество людей на 1
         */
    }

    public static void test(Book book)
    {
        book.pages = 222;
    }

    //public static тип_возращемого_значения назнвание_функции(аргументы)
}

class Book
{
    String title;
    int pages;

    public Book(String title, int pages)
    {
        this.title = title;
        this.pages = pages;
    }

    public Book(String title)
    {
        this.title = title;
        pages = 100;
    }

    public void print()
    {
        System.out.println("MyBook: " + title + " " + pages);
    }
}