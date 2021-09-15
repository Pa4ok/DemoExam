package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.school.School;
import ru.pa4ok.demoexam.school.Student;
import ru.pa4ok.demoexam.school.Teacher;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    static {
        System.out.println("class app loaded");
    }
    /*
        EquationUtil
        - public static double[] solveQuadraticEquation(double a, double b, double c)

        метод принимает коэфиценты квадратного ураравнения и возврает масссив с его корнями
        если корней нет, то можно вернуть массив с длиной 0 (new double[0])
        математические утилиты обитают в классе Math ввиде статичных функцию
     */

    public static void main(String[] args)
    {
        System.out.println("main started");
        System.out.println(Arrays.toString(EquationUtil.solveQuadraticEquation(1, -6, -7)));
    }
}