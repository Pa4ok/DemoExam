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
        int length = 10000;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        int[] arr3 = new int[length];

        Random rand = new Random();
        for(int i=0; i<length; i++) {
            arr1[i] = arr2[i] = arr3[i] = rand.nextInt(10000);
        }

        Sortinger bubble = new BubbleSortinger();
        Sortinger insert = new InsertSortinger();
        Sortinger quick = new QuickSortinger();

        System.out.println(bubble.sortWithTime(arr1) + "ms");
        System.out.println(insert.sortWithTime(arr2) + "ms");
        System.out.println(quick.sortWithTime(arr3) + "ms");
    }

    public static void sort(int[] arr, Sortinger sortinger) {
        //
    }
}
