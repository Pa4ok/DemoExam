package ru.pa4ok.demoexam;

import java.util.Arrays;

public class App
{
    /**
        статика лежит вне объектов
        можно обращаться из обычного контекста в статичный
        но нельзя из статичного в обынчый
        обращении к статиным полям и методам идет по имени класса
     */

    /*
        EquationUtil
        - public static double[] solveQuadraticEquation(double a, double b, double c)

        метод принимает коэфиценты квадратного ураравнения и возврает масссив с его корнями
        если корней нет, то можно вернуть массив с длиной 0 (new double[0])
        математические утилиты обитают в классе Math ввиде статичных функцию
     */

    public static void main(String[] args)
    {
        /*Book b1 = new Book("oiwqdjqwid");
        System.out.println(b1.title);*/

        /*System.out.println(Book.testStaticField);
        Book.testStaticMethod();
        */

        /*Book b1 = new Book("oiwqdjqwid");
        System.out.println(Math.sqrt(16));*/

        //double[] arr = new double[0];

        System.out.println(Arrays.toString(EquationUtil.solveQuadraticEquation(1, 6, -40)));
    }
}
