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
        Human h = new Human("ewfjewf");
        System.out.println(h.fio);
        System.out.println(h.toString());

        System.out.println(Human.staticField);
        Human.staticMethod();

        double d = Math.sqrt(4);
        System.out.println(d);
    }
}
