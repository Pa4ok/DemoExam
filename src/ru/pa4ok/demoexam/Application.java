package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - вызов контекстного меню по исправлению ошибки
 * cntl + space - вызов контекстного меню с доступными методами и полями объекта (после точки)
 */

public class Application
{
    /*
        создать int массив и отсортировать его любым алгоритмом
        +вывод массива до и после сортировки
     */

    public static void main(String[] args)
    {
        //System.out.println("hello fspo");

        int i1 = 2_000_000_000;
        float f = 3.5F;
        double d = 455.4324D;
        boolean b = true;
        char c = 'f';
        long l = 4_444_444_444_444_444L;

        Integer integer; //null
        Float float1 = 3.45F;
        Double double1;
        Boolean boolean1;
        Character character;
        Long long1;

        String s = "e23ijfrowefg";
        /*System.out.println(s.endsWith("fg"));
        System.out.println(s.length());
        System.out.println(s.substring(0, 4));
        System.out.println(s.charAt(5));
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        */

        /*for(int i=0; i<10; i++) {
            System.out.printf(i + " ");
        }*/

        //int[] intArr; //null
        int[] intArr1 = new int[10];
        int[] intArr2 = {1, 2, 3, 4, 5, 6, 7};

        /*for (int i = 0; i < intArr1.length; i++) {
            System.out.printf(intArr1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < intArr2.length; i++) {
            System.out.printf(intArr2[i] + " ");
        }
        System.out.println();*/

        for(int i2 : intArr2) {
            /*if(i2 % 2 == 0) {
                System.out.println(i2);
            }*/

            //System.out.println(i2 % 2 == 0 ? i2 : -5);
        }

        /*System.out.println(intArr2);
        System.out.println(Arrays.toString(intArr2));*/

    }
}
