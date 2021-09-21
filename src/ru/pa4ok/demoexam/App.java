package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        Human
        - String fio
        - char gender
        - int age
        - public boolean nextYear() //age++

        Student extends Human
        - int level
        - public boolean nextYear() //вызов родительской реализации и level++

        Teacher extends Human
        - String subject
        - int exp
        - public boolean nextYear() //вызов родительской реализации и exp++

        Building
        - String address
        - int floorCount

        School extends Building
        - String title
        - Human[] entities
        - public void nextYearAll()

        метод nextYear() должен перебирать всех обиталей школы и вызывать у них метод nextYear
        если после вызова у студента level > 11 или у преподавателя age > 60
        его необходимо выгнать (заменить на null в массиве) и вывести информацию в консоль

     */


    public static void main(String[] args)
    {
        School sc = new School(
                "pqwdihqwdhdw", 5,
                ";rlgekjreijgre",
                new Human[]{
                        new Teacher("t1", 'м', 55, "s1", 10),
                        new Teacher("t2", 'м', 58, "s1", 10),
                        new Teacher("t3", 'м', 59, "s1", 10),
                        new Human("h1", 'ж', 10),
                        new Student("s1", 'ж', 20, 11),
                        new Student("s2", 'ж', 20, 10)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
    }
}

