package ru.pa4ok.demoexam;

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
        School sc = new School(
                "wdqdqwdwdqwqd",
                new Teacher[]{
                        new Teacher("t1", 55, "a", 10),
                        null,
                        new Teacher("t2", 58, "a", 10),
                        new Teacher("t3", 60, "a", 10)

                },
                new Student[] {
                        null,
                        new Student("s1", 15, 11),
                        new Student("s2", 15, 10),
                        new Student("s3", 15, 10),
                        new Student("s4", 15, 7)
                }
        );

        test(sc);
    }

    public static void test(School sc)
    {
        System.out.println(sc);
    }
}

