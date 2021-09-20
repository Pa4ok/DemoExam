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
        Human h = new Human("wefewfewffe");
        /*System.out.println(h.fio);
        h.test();

        System.out.println(Human.staticField);
        Human.staticTest();*/

        System.out.println(Math.sqrt(16));

        double[] arr = new double[0];

        double[] arr1 = new double[] {
                1, 2, 4, 5
        };
    }
}
