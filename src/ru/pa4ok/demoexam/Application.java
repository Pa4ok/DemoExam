package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - вызов контекстного меню по исправлению ошибки
 * cntl + space - вызов контекстного меню с доступными методами и полями объекта (после точки)
 */

public class Application
{
    /*
            пока что во всех наших классах все поля будут приватными
            +должны быть публичные геттеры и сеттеры для взаимодействия с ними

            Book
            - String title
            - String author
            - int page

            Library
            - String address
            - Book[] books
            - public boolean addBook(Book book)
            - public boolean removeBook(String title, String author)

            при создании объекта Library в инициализирует массив books с какой-то заданной длиной
            при попытке доабвления книги вы ищете null элемент в массиве books
            если такой есть - ставить новую книгу на его месте и возвращаете true, если нет - false
            при удалении вы ищите не null элемент массива где будут совпадать title и author
            если такой есть ставите на его место null и возвращаете true, если нет - false

     */

    public static void main(String[] args)
    {
        //Test test = new Test(new TestSmall("34234324", 43424));

        /*TestSmall testSmall = new TestSmall("4323432", 43);
        Test test = new Test(testSmall);*/

        /*TestWithArray testWithArray = new TestWithArray();
        System.out.println(Arrays.toString(testWithArray.arr));*/

        /*String[] arr = new String[] {
            "fg3r3", "htrhrttr", "myjmyuj", "thrthjtrh"
        };
        TestWithArray testWithArray = new TestWithArray(arr);*/

        /*TestWithArray testWithArray = new TestWithArray(new String[] {
                "fg3r3", "htrhrttr", "myjmyuj", "thrthjtrh"
        });*/

        /*TestSmall[] arr = new TestSmall[] {
                new TestSmall("234234324", 432423),
                new TestSmall("234234324", 432423),
                new TestSmall("234234324", 432423),
                new TestSmall("234234324", 432423)
        };*/


        //сравнение строк
        String s1 = "123321";
        String s2 = "123";

        Scanner scanner = new Scanner(System.in);
        s2 += scanner.nextLine();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}

class TestWithArray
{
    //public String[] arr; //null

    //1
    //public String[] arr = new String[10];

    //2
    public String[] arr;

    public TestWithArray(String[] arr)
    {
        this.arr = arr;
    }

    //3
    public TestWithArray(int length)
    {
        //this.arr = new String[length];
        this(new String[length]);
    }

    public TestWithArray()
    {
        this(10);
    }
}

class TestWithCustomArray
{
    public TestSmall[] arr;

    public TestWithCustomArray(TestSmall[] arr) {
        this.arr = arr;
    }
}

class Test
{
    public TestSmall testSmall;

    public Test(TestSmall testSmall) {
        this.testSmall = testSmall;
    }
}

class TestSmall
{
    public String title;
    public int value;

    public TestSmall(String title, int value) {
        this.title = title;
        this.value = value;
    }
}
