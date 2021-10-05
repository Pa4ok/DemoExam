package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
 */

public class App
{
    /*
        abstract Sortinger
        - public abstract void sort(int[] arr)
        - public long sortWithTime(int[] arr)
        сохряняет время, вызывает sort, возвращает потраченное на сортировку время

        BubbleSortinger extends Sortinger
        наследует Sortinger и реализует функцию sort под алгоритм пузырька

        создать 2-4 класса с различными алгоритмами сортировки
        алгоритмы можно взять тут
        https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
        //Test t = new Test(5);
        //Test t = new NewTest2(5);
        //System.out.println(t);

        Test t = new Test(5) {
            @Override
            public int test() {
                return 0;
            }
        };

        System.out.println(t);

        long mills = System.currentTimeMillis();
    }
}

abstract class Test
{
    public int value;

    public Test(int value) {
        this.value = value;
    }

    public abstract int test();

    public void abc()
    {
        //...
        int i = test();
        //...
    }

    @Override
    public String toString() {
        return "Test{" +
                "value=" + value +
                '}';
    }
}

abstract class NewTest1 extends Test
{
    public NewTest1(int value) {
        super(value);
    }
}

class NewTest2 extends Test
{
    public NewTest2(int value) {
        super(value);
    }

    @Override
    public int test() {
        System.out.println("123");
        return 123;
    }
}