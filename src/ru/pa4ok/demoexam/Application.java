package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
        Human
        - String fio
        - char gender
        - int age
        - public boolean nextYear() //age++ return true

        Student extends Human
        - int level
        - public boolean nextYear() //вызывает родителькую реализацию, level++, return level > 11

        Teacher extends Human
        - String subject
        - int exp
        - public boolean nextYear() //вызывает родителькую реализацию, exp++, return age > 60

        Building
        - String address
        - int floorCount

        School extends Building
        - String title
        - Human[] entities
        - public int nextYearAll()

        метод nextYearAll() должен перебирать всех обиталей школы и увеличивать им возраст на 1
        если обитатель является Student увеличить на 1 level
        если обитатель является Teacher увеличить на 1 exp
        если level > 11 или age > 60 его необходимо выгнать (заменить на null в массиве)
        если обитатель не является ни Student ни Teacher его необходимо сразу убрать из школы

     */

    public static void main(String[] args)
    {
       School sc = new School(
                "owefjoiejfwe", 5,
                new Human[]{
                        null,
                        new Teacher("t1", 'м', 55,"dfqdqw", 20),
                        new Teacher("t2", 'м', 59,"dfqdqw", 20),
                        new Teacher("t3", 'м', 60,"dfqdqw", 20),
                        new Human("h1", 'm', 50),
                        null,
                        new Student("s1", 'ж', 20, 10),
                        new Student("s2", 'ж', 20, 10),
                        new Student("s3", 'ж', 20, 11)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
        System.out.println(sc.nextYearAll());
        System.out.println(sc);
    }
}

class A
{
    public void test() {
        System.out.println("print from A");
    }
}

class B extends A
{
    @Override
    public void test() {
        System.out.println("print from B");
        super.test();
    }
}
