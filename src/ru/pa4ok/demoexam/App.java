package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
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
                "dwdqwdqwqwdqwd",
                new Teacher[]{
                        null,
                        new Teacher("t1", 55, "s1", 10),
                        null,
                        new Teacher("t2", 57, "s1", 10),
                        new Teacher("t3", 59, "s1", 10)
                },
                new Student[]{
                        null,
                        new Student("s1", 15, 9),
                        new Student("s2", 15, 9),
                        new Student("s3", 15, 10),
                        new Student("s4", 15, 11),
                        null
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
        System.out.println(sc.nextYearAll());
        System.out.println(sc);*/


        /*Human h = new Human("h1", 'm', 20);
        Teacher t = new Teacher("t1", 'w', 21, "subj", 2);

        System.out.println(h);
        h.test();

        System.out.println();

        System.out.println(t);
        t.test();*/

        //Human h = new Teacher("t1", 'w', 21, "subj", 2);
        Human h = new Student("s1", 'w', 21, 10);

        /*System.out.println(h);
        Teacher t = (Teacher) h;
        t.age++;
        System.out.println(h);*/

        /*System.out.println(h instanceof Human);
        System.out.println(h instanceof Student);
        System.out.println(h instanceof Teacher);*/

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            System.out.println("detect teacher: " + t);
        } else if(h instanceof Student) {
            Student s = (Student) h;
            System.out.println("detect student: " + s);
        }
    }

    public static void test(Human h)
    {
        if(h instanceof Teacher) {
            //...
        } else if(h instanceof Student) {
            //...
        } else {
            //...
        }
    }
}
