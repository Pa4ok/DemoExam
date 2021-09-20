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

        Student extends Human
        - int level

        Teacher extends Human
        - String subject
        - int exp

        Building
        - String address
        - int floorCount

        School extends Building
        - String title
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
        /*Teacher t = new Teacher("fio1", 'м', 50, "s1", 23);
        System.out.println(t);
        t.test();*/

        /*Human h = new Teacher("fio1", 'м', 50, "s1", 23);
        System.out.println(h);*/

        Human h = new Student("123123sdwds", 'v', 15, 11);
        System.out.println(h);

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            System.out.println(t.getSubject());
        } else if(h instanceof Student) {
            Student s = (Student) h;
            System.out.println(s.getLevel());
        }

        //java 15+
        //if(h instanceof Teacher t) {
        //}
    }

    public static void addYear(Human h)
    {
        h.age++;
        if(h instanceof Teacher) {
            ((Teacher)h).exp++;
        } else if(h instanceof Student) {
            ((Student)h).level++;
        }
    }
}

