package ru.pa4ok.demoexam;


import java.util.Random;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
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
        /*NewTest1 t = new NewTest1(1);
        System.out.println(t.test("ABC"));

        System.out.println(t);*/

        /*Test t = new Test(5) {
            @Override
            public String test(String s) {
                return "123";
            }
        };*/

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);

        long mills = System.currentTimeMillis();
    }
}

abstract class Test
{
    public int value;

    public Test(int value) {
        this.value = value;
    }

    public abstract String test(String s);

    public void test1() {
        String s = test("ABC");
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
    public String test(String s) {
        return s.toLowerCase();
    }
}