package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.school.School;
import ru.pa4ok.demoexam.school.Student;
import ru.pa4ok.demoexam.school.Teacher;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
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
        System.out.println(Arrays.toString(EquationUtil.solveQuadraticEquation(3, -14, -5)));
    }
}

