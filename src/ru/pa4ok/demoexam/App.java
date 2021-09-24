package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.Student;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */
public class App
{
    /*
        Human
        - String fio
        - char gender
        - int age
        - public boolean nextYear() //age++ return true

        Student extends Human
        - int level
        - public boolean nextYear() //вызываем родительскую реализацию, level++, return level > 11

        Teacher extends Human
        - String subject
        - int exp
        - public boolean nextYear() //вызываем родительскую реализацию, exp++, return age > 60

        Building
        - String address
        - int floorCount

        School extends Building
        - String title
        - Human[] entities
        - public int nextYearAll()

        метод nextYearAll() должен перебирать всех обиталей школы и вызывать у них метод nextYear()
        если возврается true текущий объект массива надо заменить на null
        возвращаемое значение - количество людей покинувших школу на этом этапе
     */


    public static void main(String[] args)
    {
        /*School sc = new School(
                "oqliwduhqwdud", 5,
                new Human[] {
                        null,
                        new Teacher("t1", 'ж', 55, "subject", 10),
                        new Teacher("t2", 'ж', 58, "subject", 10),
                        new Teacher("t3", 'ж', 59, "subject", 10),
                        new Student("s1", 'м', 20, 10),
                        new Student("s2", 'м', 20, 10),
                        null,
                        new Student("s3", 'м', 20, 11)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
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
        super.test();
        System.out.println("test from B");
    }
}
