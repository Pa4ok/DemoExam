package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.school.School;
import ru.pa4ok.demoexam.school.Student;
import ru.pa4ok.demoexam.school.Teacher;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
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
        /*Student s = new Student("112d1d", 123, 123);
        System.out.println(s.getFio());
        System.out.println(Student.staticIntField);
        Student.testStaticMethod();*/

        Student.testStaticMethod();
        test();
    }

    public static void test() {

    }
}