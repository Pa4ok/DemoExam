package ru.pa4ok.demoexam;

import java.util.Arrays;

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
        - public void addBook(Book b)

        при добавлении книги вы ищете первый null элемент в массиве books
        если такой есть - ставите книгу из аргументов на его место
        если в массиве нет null элментов, то выводите что нибудь в консоль
     */
    
    public static void main(String[] args)
    {
        //Test t = new Test();
        //System.out.println(t.arr);

        /*System.out.println(Arrays.toString(t.arr));
        t.arr[1] = new TestSmall(1);
        System.out.println(Arrays.toString(t.arr));*/

        TestSmall[] testArray = new TestSmall[] {
                new TestSmall(1),
                new TestSmall(2),
                new TestSmall(3),
                null,
                new TestSmall(4),
                new TestSmall(5),
                null
        };

        /*Test t = new Test(testArray);
        System.out.println(Arrays.toString(t.arr));*/

        Test t = new Test();
        t.arr = testArray;
        System.out.println(Arrays.toString(t.arr));

    }
}

class Test
{
    //public TestSmall[] arr; //null

    //1
    //public TestSmall[] arr = new TestSmall[3];

    //2
    /*public TestSmall[] arr;

    public Test(TestSmall[] arr) {
        this.arr = arr;
    }

    public Test(int length) {
        this(new TestSmall[length]);
    }

    public Test() {
        this(3);
    }*/

    public TestSmall[] arr;

    public Test() {
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
