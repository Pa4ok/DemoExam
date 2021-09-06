package ru.pa4ok.demoexam;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
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
        /*House[] houses = new House[10];
        System.out.println(Arrays.toString(houses));

        House[] houses1 = new House[] {
                new House("wqdwqdwq", 2 ,2),
                new House("wqdwqdwq", 2 ,2),
                new House("wqdwqdwq", 2 ,2),
                new House("wqdwqdwq", 2 ,2)
        };*/

        /*House h1 = new House("wqdwqdwq", 2 ,2);
        House h2 = new House("wqdwqdwq", 2 ,2);
        System.out.println(h1 == h2);*/

        String s1 = "123321";

        Scanner scanner = new Scanner(System.in);
        String s2 = "123" + scanner.nextLine();

        System.out.println(s1 + " " + s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}

class Test
{
    //1
    //public House[] houses = new House[10];

    public House[] houses;

    //2
    public Test(House[] houses)
    {
       this.houses = houses;
    }

    public Test(int length)
    {
        this.houses = new House[length];
    }

    public Test()
    {
        this(10);
    }
}
