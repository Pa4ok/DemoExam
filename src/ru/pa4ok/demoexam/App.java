package ru.pa4ok.demoexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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
        int length = 100000;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        Random rand = new Random();
        for(int i=0; i<length; i++) {
            arr1[i] = arr2[i] = rand.nextInt(10000);
        }

        Sortinger bubble = new BubbleSortinger();
        Sortinger quick = new QuickSortinger();
        
        System.out.println(bubble.sortWithTime(arr1) + "ms");
        System.out.println(quick.sortWithTime(arr2) + "ms");
    }
}
