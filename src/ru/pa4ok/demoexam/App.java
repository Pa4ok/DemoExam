package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

        EquationUtil
        - public static double[] solveQuadraticEquation(double a, double b, double c)

        метод принимает коэфиценты квадратного ураравнения и возврает масссив с его корнями
        если корней нет, то можно вернуть массив с длиной 0 (new double[0])
        математические утилиты обитают в классе Math ввиде статичных функцию
     */

    public static void main(String[] args)
    {
        //double[] arr = new double[0];

        /*Student s = new Student("weg'wefojewf", 10);
        System.out.println(s.level);
        s.test();

        //System.out.println(Student.testStaticField);
        Student.testStaticMethod();

        */

/*
        System.out.println(Math.sqrt(16));
        Student s = new Student("weg'wefojewf", 10);
        System.out.println(s.fio);
*/

        System.out.println(Arrays.toString(EquationUtil.solveQuadraticEquation(1, -8, 12)));
    }
}

