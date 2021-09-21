package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
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
        - public boolean addBook(Book b)
        - public boolean removeBook(String title, String author)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        и возвращаете true, если нет - возвращаете false

        при удалении книги вы ищете книгу с таким же названием и автором
        если такая книга есть - ставите на нее место в массиве null
        и возвращаете true, если нет - возвращаете false
     */
    
    public static void main(String[] args)
    {
        /*Library lib = new Library(
                "we;fjhewoifew",
                new Book[]{
                        null,
                        new Book("book1", "author1", 100),
                        new Book("book2", "author2", 100),
                        null,
                        new Book("book3", "author3", 100),
                        new Book("book4", "author4", 100),
                        new Book("book5", "author5", 100)
                }
        );
        System.out.println(lib);
        lib.addBook(new Book("book5", "author5", 100));
        lib.addBook(new Book("book6", "author6", 100));
        lib.addBook(new Book("book7", "author7", 100));
        System.out.println(lib);*/

        String s1 = "123321";
        String s2 = "123";

        Scanner scanner = new Scanner(System.in);
        s2 += scanner.nextLine();

        System.out.println(s1 + " " + s1.length());
        System.out.println(s2 + " " + s2.length()) ;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        /*String[] arr = new String[3];
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0].equals("123"));*/
    }
}

