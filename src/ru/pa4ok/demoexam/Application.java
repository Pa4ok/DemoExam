package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
        abstract Sortinger
        - public abstract void sort(int[] arr)
        - public long sortWithTime(int[] arr)

        sortWithTime сохранять время до сортировки
        вызывать метод сортировки
        считать потраченное время и возвращать его

        BubbleSortinger extends Sortinger
        - public void sort(int[] arr) //реализация для конкретного алгоритма

        +2-3 класса с другими алгоритмами сортировки
        https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
        int length = 10000;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];

        Random rand = new Random();
        for(int i=0; i<length; i++) {
            arr1[i] = arr2[i] = rand.nextInt(10000);
        }

        BubbleSortinger bubble = new BubbleSortinger();
        QuickSortinger quick = new QuickSortinger();

        System.out.println(bubble.sortWithTime(arr1) + "ms");
        System.out.println(quick.sortWithTime(arr2) + "ms");
    }
}
