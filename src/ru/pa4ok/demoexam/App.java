package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        Point
        - double x
        - double z

        Figure
        - String title
        - Point[] points
        - public double calculateSquare() //return -1

        Triangle
        - конструктор на 3 точки, передает массив из них в родительский конструкор
        - public double calculateSquare() //считает уже по формуле для триугольника

        Rectangle
        - конструктор на 4 точки, передает массив из них в родительский конструкор
        - public double calculateSquare() //считает уже по формуле для прямоугольника



     */


    public static void main(String[] args)
    {
        School sc = new School(
                "pqwdihqwdhdw", 5,
                ";rlgekjreijgre",
                new Human[]{
                        new Teacher("t1", 'м', 55, "s1", 10),
                        new Teacher("t2", 'м', 58, "s1", 10),
                        new Teacher("t3", 'м', 59, "s1", 10),
                        new Human("h1", 'ж', 10),
                        new Student("s1", 'ж', 20, 11),
                        new Student("s2", 'ж', 20, 10)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);

    }
}

//финальный класс нельзя унаследовать
final class A
{

}

/*class B extends A
{

}*/
