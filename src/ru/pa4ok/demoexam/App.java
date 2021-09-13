package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class App
{
    /*
        все поля в классах приватные + геттеры и сеттеры
        +конструктор на все поля и переопределенный вывод (toString)

        Student
        - String fio
        - int age
        - int level //класс

        Teacher
        - String fio
        - int age
        - String subject
        - int exp //стаж

        School
        - String address
        - Teacher[] teachers
        - Student[] students
        - public void nextYear()

        метод nextYear() означает то что в школе прошел еще 1 год

        всем студентам и преподаветелям необходимо увеличить возраст на 1
        студентам также необходимо увеличить класс на 1
        преподавателям также неонбходимо увеличить стаж на 1

        если после увеличения класса стундента он >11 его необхдимо удалить (заменить на null)
        и написать в консоль о том что он выпустился

        если после увеличения возраста преподавателя он >60 его необходимо удалить (заменить на null)
        и написать в консоль о том что он ушел на пенсию
     */

    public static void main(String[] args)
    {
        Teacher[] teachers = new Teacher[] {
                new Teacher("t1", 55, "s1", 10),
                null,
                new Teacher("t2", 58, "s2", 11),
                new Teacher("t3", 59, "s3", 12)
        };

        Student[] students = new Student[] {
                new Student("s1", 15, 8),
                null,
                new Student("s2", 15, 9),
                new Student("s3", 15, 9),
                new Student("s4", 15, 11)
        };

        School school = new School("fojweoiwf", teachers, students);
        System.out.println(school);
        for(int i=0; i<3; i++) {
            System.out.println();
            school.nextYear();
            System.out.println(school);
            System.out.println();
        }
    }
}
