package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
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
        - public void addBook(Book book)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        если в массиве нет null элментов, то выводите что нибудь в консоль
     */

    public static void main(String[] args)
    {
        //Test test = new Test();
        //System.out.println(test.arr);

        /*TestSmall[] arr = new TestSmall[] {
                new TestSmall(1),
                new TestSmall(2),
                new TestSmall(3),
                null,
                new TestSmall(5),
        };

        Test test = new Test(arr);*/

        Test test = new Test(3);
        test.arr[1] = new TestSmall(123);

        System.out.println(Arrays.toString(test.arr));
    }
}

class Test
{
    //public TestSmall[] arr; //null

    //1
    //public TestSmall[] arr = new TestSmall[10];

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
        return "TestSmall{" +
                "value=" + value +
                '}';
    }
}