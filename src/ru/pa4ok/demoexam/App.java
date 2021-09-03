package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Random;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * cntl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    public static void main(String[] args)
    {
        /*
            сделать функцию которая создает и возращает int[]
            в аргументы принимает размерность массива

            2 функция принимает массив и заполняет его рандомными значениями

            3 функция принимает массив и сортирует его любым алгоритмом
          */

        int[] arr = createArray(10);
        System.out.println(Arrays.toString(arr));
        randArray(arr);
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
        test(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] createArray(int length)
    {
        /*int[] arr = new int[length];
        return arr;*/

        return new int[length];
    }

    public static void randArray(int[] arr)
    {
        Random rand = new Random();
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    public static void sortArray(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void test(int[] arr)
    {
        for(int i : arr) {
            i = 10;
        }
    }
}

