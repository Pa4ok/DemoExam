package ru.pa4ok.demoexam;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
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

        nextYearAll перебирает всех обиталелей школы и вызывает у них метод nextYear
        если он возвращает true, то текущего обиталя надо заменить на null
        сам метод возврает количество людей покинувших школу "за вызов"

     */


    public static void main(String[] args)
    {
        /*School sc = new School(
                "wefoihweofhwef", 5,
                new Human[] {
                        new Teacher("t1", 'w', 55, "subj", 20),
                        new Teacher("t2", 'w', 58, "subj", 20),
                        new Teacher("t3", 'w', 58, "subj", 20),
                        new Student("s1", 'w', 20, 7),
                        null,
                        new Human("h1", 'm', 30),
                        new Student("s1", 'w', 20, 9),
                        new Student("s1", 'w', 20, 10),
                        new Teacher("t4", 'w', 60, "subj", 20)
                }
        );

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);*/

        A[] arr = new A[] {
                new A(),
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