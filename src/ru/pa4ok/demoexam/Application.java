package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    public static void main(String[] args)
    {
        /*Book b1 = new Book("awfeewfwfeewf");
        Book b2 = new Book("awfeewfwfeewf");
        Book b3 = new Book("awfeewfwfeewf");
        Book b4 = new Book("awfeewfwfeewf");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        */

        long startMills = System.currentTimeMillis();

        /*String s1 = "";
        for(int i=0; i<10000; i++) {
            s1 += i;
            s1 += ' ';
            s1 += "#ewf";
        }*/

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10000; i++) {
            sb.append(i);
            sb.append(' ');
            sb.append("#ewf");
        }
        String s1 = sb.toString();

        System.out.println(s1.length() + " " + (System.currentTimeMillis() - startMills) + "ms");

    }
}
