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
    /*
        задача
        создать int массив и отсортировать его любым алгоритмом
        +вывод в консоль до и после сортивки
     */

    public static void main(String[] args)
    {
        /*int i1 = 2_100_000_000;
        float f = 2.4F;
        double d = 3.5534D;
        long l = 10_000_000_000_000L;
        boolean b = true;
        char c = 'd';
        String s = "wefjewpfjwefw3r3r23ff3";

        //java 15+
        String ss = """
                wdpoiwqjdwqjdwq
                pewfjpoiwefjep
                pewhjfiwefewf
                oiwefhoiwef
                """;*/

        /*for(int i=0; i<15; i++)
        {
            //sout
            //System.out.println(i);
            if(i % 2 == 0) {
                System.out.printf(i + " ");
            }
        }*/

        /*while(true) {
        }*/

        /*String s1 = "1234DWdwe[feohf54";
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.length());
        System.out.println(s1.substring(0, 5));
        System.out.println(s1.endsWith("f54"));*/

        //int[] iArr; //null
        //int[] iArr = new int[10];

        /*int[] iArr1 = { 1, 2, 3, 4, 5, 6, 7};

        //System.out.println(iArr1);
        for(int i=0; i<iArr1.length; i++) {
            System.out.printf(iArr1[i] + " ");
        }
        System.out.println();*/

        //System.out.println(Arrays.toString(iArr1));

        /*String[] sArr = new String[10];
        sArr[4] = "123123213213";

        System.out.println(Arrays.toString(sArr));

        for(String s3 : sArr) {
            System.out.println(s3);
        }*/

        /*у всех примитивов есть глобальные ссылочные типы данных
          у примитивов есть дефотные значения
          у глобальных типов, как и всех ссылочных типов данных по умолчанию null
        */

        /*Integer integer; //null
        Float float1;
        Double double1;
        Boolean boolean1 = null;
        Long long1;
        Character character;

        Integer i5 = 3423;
        if(boolean1 == null) {
            System.out.println("null 123");
        }*/

        /*int[] arr = {3, 6, 8, 4, -1, 6, 1, 9};

        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));*/

        //int[] arr; //null
        /*int[] arr = new int[10];
        for(int i=0; i<arr.length; i++) {
            arr[i] = i * 2;
        }
        System.out.println(Arrays.toString(arr));
        incrementArray(arr);
        System.out.println(Arrays.toString(arr));*/

        /*int i = 10;
        System.out.println(i);
        test(i);
        System.out.println(i);*/

        Random rand = new Random();
        int i1 = rand.nextInt();
        int i2 = rand.nextInt(1000);
        System.out.println(i1 + " " + i2);

        /*
            сделать функцию которая создает и возращает int[]
            в аргументы принимает размерность массива

            2 функция принимает массив и заполняет его рандомными значениями

            3 функция принимает массив и сортирует его любым алгоритмом
          */
    }

    //public static int[] createArray(int length) {}

    public static void incrementArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++) {
            arr[i]++;
        }
    }

    public static void test(int i)
    {
        i++;
    }
}
