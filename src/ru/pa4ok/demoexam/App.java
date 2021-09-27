package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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
        /*Human h = new Human("h1", 'w', 44);
        Teacher t = new Teacher("t1", 'm', 43, "subject", 10);

        System.out.println(h);
        System.out.println(t);

        System.out.println();

        //h.test();
        t.test();*/

        //Human h = new Teacher("t1", 'm', 43, "subject", 10);
        Human h = new Student("s1", 'm', 43, 10);

        /*System.out.println(h);
        Teacher t = (Teacher) h;
        System.out.println(t.getSubject());
        t.exp++;
        System.out.println(h);*/

        /*System.out.println(h instanceof Human);
        System.out.println(h instanceof Teacher);
        System.out.println(h instanceof Student);*/

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            System.out.println("teacher detected");
        } else if(h instanceof Student) {
            Student s = (Student) h;
            System.out.println("student detected");
        }
    }

    public static void incrementYear(Human h)
    {
        //...
    }
}

