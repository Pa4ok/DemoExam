package ru.pa4ok.demoexam;

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
        /*Car c = new Car("123werffef");
        System.out.println(c.type);
        */

        /*System.out.println(Car.staticField);
        Car.staticMethod();
        */

        System.out.println(Math.sqrt(16));

        Car c = new Car("123werffef");
        System.out.println(c.type);

        //double[] d = new double[0];

        double[] d = {
                1, 2, 3, 4, 5
        };
    }
}
