package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App //
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
        //NewTest t = new NewTest(5);

        Test t = new Test(5) {
            @Override
            public String test(int i) {
                return null;
            }
        };

        System.out.println(t);
        System.out.println(t.test(10));

        ABC abc = new ABC() {
            @Override
            public void test() {
                System.out.println("CBA");
            }
        };

        //время в милисекундах
        long mills = System.currentTimeMillis();

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
    }
}

class ABC
{
    public void test() {
        System.out.println("ABC");
    }
}

abstract class Test
{
    public int value;

    public Test(int value) {
        this.value = value;
    }

    public abstract String test(int i);

    public void abc() {
        test(5);
    }

    @Override
    public String toString() {
        return "Test{" +
                "value=" + value +
                '}';
    }
}

/*abstract class NewTest extends Test
{
    public NewTest(int value) {
        super(value);
    }
}*/

class NewTest extends Test
{
    public NewTest(int value) {
        super(value);
    }

    @Override
    public String test(int i) {
        return "spedwfoiwefef " + i;
    }
}