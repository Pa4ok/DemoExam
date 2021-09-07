package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 */

public class App
{
    /*
        все поля приватные
        конструктор на все необходимые поля
        переопределенный вывод (toString)
        геттеры и сеттеры

        Book
        - String title
        - String author
        - int pages

        Library
        - String address
        - Book[] books
        - public boolean addBook(Book book)
        - public boolean removeBook(String title)

        у Library будет 2 констора
        1 - принимает сразу массив книг, 2 - принимает длину и инициализирует массив с этой длиной
        при добавлении книги, вы перебираете массив и ищете null элемнт
        если таковой есть - то ставите на его место книгу и возращаете true, если нет - false
        при удалении вы ищете книгу с таким же названием, если она есть - ставите null в массив
        и возращаете true, если нет - false

     */

    public static void main(String[] args)
    {
        //Test test = new Test();
        //System.out.println(test.arr);

        /*Test test = new Test(new String[] {
                "WEFWEFWEFEWF",
                "WEFRFEW3F",
                "erger"
        });*/

        //Test test = new Test();
        //System.out.println(Arrays.toString(test.arr));

        String s1 = "123321";
        String s2 = "123";

        Scanner scanner = new Scanner(System.in);
        s2 += scanner.nextLine();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Test
{
    //1
    //public String[] arr = new String[10];

    public String[] arr;

    //2
    public Test()
    {
        arr = new String[10];
    }

    //3
    public Test(String[] arr)
    {
        this.arr = arr;
    }
}


