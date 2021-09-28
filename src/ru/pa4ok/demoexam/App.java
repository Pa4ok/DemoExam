package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        Human
        - String fio
        - char gender
        - int age

        Student extends Human
        - int level

        Teacher extends Human
        - String subject
        - int exp

        Building
        - String address
        - int floorCount

        School extends Building
        - Human[] entities
        - public void nextYear()

        метод nextYear() должен перебирать всех обиталей школы и увеличивать им возраст на 1
        если обитатель является Student увеличить на 1 level
        если обитатель является Teacher увеличить на 1 exp
        если level > 11 или age > 60 его необходимо выгнать (заменить на null в массиве)
        если обитатель не является ни Student, ни Teacher его необходимо сразу заменить на null
        и вывести информацию в консоль

     */

    public static void main(String[] args)
    {
        /*School sc = new School(
                "dqoqoidwqdwqoijd",
                new Teacher[]{
                        new Teacher("t1", 55, "qwdwqw", 20),
                        new Teacher("t2", 58, "qwdwqw", 20),
                        new Teacher("t3", 60, "qwdwqw", 20),
                },
                new Student[]{
                        new Student("s1", 15, 7),
                        new Student("s2", 15, 9),
                        new Student("s3", 15, 9),
                        new Student("s4", 15, 11)
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
        System.out.println(sc);*/

        /*Human h = new Human("h1", 'w', 50);
        Student s = new Student("s1", 'm', 30, 10);

        //System.out.println(h);
        //System.out.println(s);

        h.test();
        System.out.println();
        s.test();*/

        //Human h = new Student("s1", 'm', 30, 10);
        Human h = new Teacher("t1", 'w', 25, "wafefew", 5);

        /*System.out.println(h);
        Student s = (Student) h;
        s.setLevel(5);
        System.out.println(h);*/

        /*System.out.println(h instanceof Human);
        System.out.println(h instanceof Teacher);
        System.out.println(h instanceof Student);
        */

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            //...
        } else if(h instanceof Student) {
            Student s = (Student) h;
            //...
        }
    }
}

