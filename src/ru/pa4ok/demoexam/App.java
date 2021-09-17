package ru.pa4ok.demoexam;

import java.util.Arrays;

public class App
{
    /*
        EquationUtil
        - public static double[] solveQuadraticEquation(double a, double b, double c)

        метод принимает коэфиценты квадратного ураравнения и возврает масссив с его корнями
        если корней нет, то можно вернуть массив с длиной 0 (new double[0])
        математические утилиты обитают в классе Math ввиде статичных функцию

     */

    public static void main(String[] args)
    {
        /*System.out.println(Arrays.toString(EquationUtil.solveQuadraticEquation(1, -6, -7)));*/

        Car[] arr = new Car[10];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new Car("type-123");
        }
        System.out.println(Arrays.toString(arr));
    }
}
