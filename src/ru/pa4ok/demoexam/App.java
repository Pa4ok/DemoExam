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
        - public boolean nextYear() //age++ | return true

        Student extends Human
        - int level
        - public boolean nextYear() //вызов родительской реализации | level++ | return level > 11

        Teacher extends Human
        - String subject
        - int exp
        - public boolean nextYear() //вызов родительской реализации | exp++ | return age > 60

        Building
        - String address
        - int floorCount

        School extends Building
        - Human[] entities
        - public int nextYearAll()
     */

    public static void main(String[] args)
    {
        /*School sc = new School(
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
        System.out.println(sc);*/

        A[] arr = new A[] {
                new A(),
                new A(),
                new B(),
                new B()
        };

        for(A a : arr) {
            System.out.println(a.getClass());
            a.test();
            System.out.println();
        }
    }
}

class A
{
    public void test() {
        System.out.println("test from A");
    }
}

class B extends A
{
    @Override
    public void test() {
        System.out.println("test from B");
    }
}