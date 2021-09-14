package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            конструктор, переопределенный вывод (toString)
            все поля приватные + геттеры и сеттеры

            Book
            - String title
            - String author
            - int pages

            Library
            - String address
            - Book[] books
            - public boolean addBook(Book book)
            - public boolean removeBook(String title, String author)

            метод addBook() должен перебирать массив с книгами
            если в нем есть пустой (null) элемент, то он должен на его место поставить книгу и вернуть true
            если в массиве нет ни 1 такого элемента - вернуть false

            метод removeBook() должен перебирать массив с книгами
            если в нем есть книга с равным названием и автором к тем что пришли в метод
            то на ее место нужно поставить null и вернуть true, если нет - вернуть false
         */

        Book[] books = new Book[] {
                null,
                new Book("1", "1", 1),
                new Book("2", "1", 2),
                null,
                new Book("3", "1", 3),
                new Book("4", "1", 4)
        };

        Library lib = new Library("wdqdqwddwq", books);
        System.out.println(lib);
        System.out.println(lib.addBook(new Book("5", "5", 5)));
        System.out.println(lib.removeBook("1", "1"));
        System.out.println(lib.removeBook("1", "1feewfwfefew"));
        System.out.println(lib.addBook(new Book("5", "5", 5)));
        System.out.println(lib.addBook(new Book("5", "5", 5)));
        System.out.println(lib.addBook(new Book("5", "5", 5)));
        System.out.println(lib.addBook(new Book("5", "5", 5)));
        System.out.println(lib);


        /*String s1 = "123321";
        String s2 = "123";

        Scanner scanner = new Scanner(System.in);
        s2 += scanner.nextLine();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));*/

        /*String[] arr = new String[3];
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0].equals("132"));*/
    }
}

