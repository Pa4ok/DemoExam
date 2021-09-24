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
        School sc = new School(
                "dwdqwdqwqwdqwd", 5,
                new Human[]{
                        null,
                        new Teacher("t1",'w', 55, "s1", 10),
                        null,
                        new Teacher("t2",'w', 57, "s1", 10),
                        new Teacher("t3",'w', 59, "s1", 10),
                        new Student("s1",'w', 15, 9),
                        new Student("s2",'w', 15, 9),
                        new Student("s3",'w', 15, 10),
                        new Student("s4",'w', 15, 11),
                        new Human("h1",'w', 15)
                }
        );

        System.out.println(sc);
        sc.nextYear();
        System.out.println(sc);
        sc.nextYear();
        System.out.println(sc);
        sc.nextYear();
        System.out.println(sc);
        sc.nextYear();
        System.out.println(sc);
    }
}
