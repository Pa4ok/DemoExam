package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
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

            метод nextYear обозначет то что в школе прошел 1 год
            данный метод должен увеличивать возраст всех учителей и студентов на 1
            также он должен увеличить у них класс и стаж на 1

            если после увеличения класса студента он > 11 то его надо убрать из школы (заменить на null)
            и вывести информацию в консоль о том что он выпустился

            если после увеличения возраста преподавателя он > 60 то его надо убрать из школы (заменить на null)
            и вывести информацию в консоль о том что он ушел на пенсию
     */

    public static void main(String[] args)
    {

    }
}
