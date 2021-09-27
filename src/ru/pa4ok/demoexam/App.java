package ru.pa4ok.demoexam;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
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
        //Test t = new Test();
        /*NewTest1 t = new NewTest1(1);

        Test t1 = new Test(3) {
            @Override
            public void test(int t) {
                System.out.println(t);
            }
        };*/

        Random rand = new Random();
        int i = rand.nextInt();
        int i1 = rand.nextInt(1000);

        long mills = System.currentTimeMillis();
    }
}

abstract class Test
{
    public int value;

    public Test(int value) {
        this.value = value;
    }

    public abstract void test(int t);

    public void abc() {
        test(4);
    }

    @Override
    public String toString() {
        return "Test{" +
                "value=" + value +
                '}';
    }
}

abstract class NewTest extends Test
{
    GridPane

    public NewTest(int value) {
        super(value);
    }
}

class NewTest1 extends Test
{
    public NewTest1(int value) {
        super(value);
    }

    @Override
    public void test(int t) {
        System.out.println("test " + t);
    }
}