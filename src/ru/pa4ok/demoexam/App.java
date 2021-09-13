package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
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
            - int pages

            Library
            - String address
            - Book[] books
            - public void addBook(Book book)

            метод addBook() должен перебирать массив с книгами
            если в нем есть пустой (null) элемент, то он должен на его место поставить книгу
            если в массиве нет ни 1 такого элемента, то вывести информацию в консоль
         */

        //Test t = new Test();
        //System.out.println(t.arr);
        //System.out.println(Arrays.toString(t.arr));

        /*TestSmall[] arr = new TestSmall[] {
                new TestSmall(1),
                new TestSmall(2),
                new TestSmall(3),
                null,
                new TestSmall(5),
        };

        Test t = new Test(arr);
        System.out.println(Arrays.toString(t.arr));*/

        Test t = new Test(new TestSmall[] {
                new TestSmall(1),
                new TestSmall(2),
                new TestSmall(3),
                null,
                new TestSmall(5),
        });
        System.out.println(Arrays.toString(t.arr));
    }
}

class Test
{
    //public TestSmall[] arr; //null

    //1
    //public TestSmall[] arr = new TestSmall[3];

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

    @Override
    public String toString() {
        return "TestSmall{" +
                "value=" + value +
                '}';
    }
}
