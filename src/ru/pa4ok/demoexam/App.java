package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */
public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

            Student
            - String fio
            - int age
            - int level //класс
            - public boolean nextYear() //age++ level++

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж
            - public boolean nextYear() //age++ exp++

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public int nextYearAll()

            boolean nextYear() в Student и Teacher возвращают true
            если они должны покинуть школу после увеличения значений

            int nextYearAll() возвращает общее количество участников
            которые покинули школу после увеличения на этом вызове метода
     */

    public static void main(String[] args)
    {
        School sc = new School(
                "dfqwdqwd",
                new Teacher[] {
                        null,
                        new Teacher("t1", 55, "ewd", 12),
                        new Teacher("t2", 58, "ewd", 12),
                        new Teacher("t3", 59, "ewd", 12),
                        null
                },
                new Student[] {
                        null,
                        new Student("s1", 15, 7),
                        null,
                        new Student("s1", 15, 9),
                        new Student("s1", 15, 9),
                        new Student("s1", 15, 10)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);

    }
}
