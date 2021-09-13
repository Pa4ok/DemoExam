package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
        конструктор на все поля + toString
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

        в методе addBook вы перебираете элементы массива
        и ищите null элемент, если таковой есть - ставите на его место
        книгу, которая пришла в аргументах и возраете true, если нет - false

        в методе removeBook вы перебираете элементы массива
        и ищете не null элемент у которого title и author равны тем что пришли в аргументах
        если такой элемент есть - ставите на его место null и возвращаете true
        если нет - false
         */

        /*Book[] books = new Book[] {
                null,
                new Book("1", 1),
                null,
                new Book("2", 2),
                new Book("3", 3)
        };

        Library lib = new Library("wqadqw[odiqwd", books);
        System.out.println(lib);
        lib.addBook(new Book("4", 4));
        lib.addBook(new Book("5", 5));
        lib.addBook(new Book("6", 6));
        System.out.println(lib);*/

        String s1 = "123321";
        String s2 = "123";

        Scanner scanner = new Scanner(System.in);
        s2 += scanner.nextLine();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        //String[] arr = new String[10];
        //System.out.println(arr[0].equals("123"));
    }
}

