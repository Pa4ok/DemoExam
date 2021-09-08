package ru.pa4ok.demoexam;

import java.util.Arrays;

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
        - int pages

        Library
        - String address
        - Book[] books
        - public void addBook(Book book)

        в методе addBook вы перебираете элементы массива
        и ищите null элемент, если таковой есть - ставите на его место
        книгу, которая пришла в аргументах
         */

        /*Test test = new Test();
        System.out.println(Arrays.toString(test.arr));
        test.arr[5] = "23423432";
        System.out.println(Arrays.toString(test.arr));*/

        /*String[] arr = {
            "fewfwe", "jytjtn", "dqwefewfg"
        };
        Test test = new Test(arr);
        System.out.println(Arrays.toString(test.arr));*/

        TestSmall[] arr = new TestSmall[] {
                new TestSmall(1),
                new TestSmall(2),
                null,
                null,
                new TestSmall(3),
                new TestSmall(4),
                null,
                new TestSmall(5)
        };
        Test test = new Test(arr);
        System.out.println(Arrays.toString(test.arr));
    }
}

class Test
{
    //public String[] arr; //null

    //1
    //public String[] arr = new String[10];

    //2
    public TestSmall[] arr;

    public Test(TestSmall[] arr) {
        this.arr = arr;
    }

    public Test(int length) {
        this(new TestSmall[length]);
    }

    public Test() {
        this(10);
    }
}

class TestSmall
{
    public int value;

    public TestSmall(int value) {
        this.value = value;
    }

    public String toString() {
        return "TestSmall: " + this.value;
    }
}
