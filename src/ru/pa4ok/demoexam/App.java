package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

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
        - public boolean addBook(Book book)
        - public boolean removeBook(String title, String author)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        и возвращаете true, если пустого элемента нет - возвращаете false

        при удалении книги вы ищете не null элемент у коготорого совпадают
        название и автор с теми что пришли в аргументах
        если такой элемент есть - ставите на его месте null и возвращете true
        если нет - false
     */

    public static void main(String[] args)
    {
        /*Book[] books = new Book[] {
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

        /*String[] arr = new String[10];
        System.out.println(Arrays.toString(arr));
        String s1 = "123";
        System.out.println(arr[0].equals(s1));*/


    }
}
