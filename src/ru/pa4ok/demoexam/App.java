package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
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

        метод nextYearAll() должен перебирать всех обиталей школы и вызывать у них метод nextYear
        если он возвращает true данного участника необходимо удалить из школы (заменить на null)
        возвращает метод количество людей покинувших школу на этом этапе

     */

    public static void main(String[] args)
    {
        School school = new School(
                "fojweoiwf", 5,
                new Human[] {
                        new Teacher("t1", 'м', 55, "s1", 10),
                        null,
                        new Teacher("t2", 'м', 58, "s2", 11),
                        new Teacher("t3", 'м', 59, "s3", 12),
                        new Human("h1", 'ж', 30),
                        new Student("s1", 'м', 15, 8),
                        null,
                        new Student("s2", 'м', 15, 9),
                        new Student("s3", 'м', 15, 9),
                        new Student("s4", 'м', 15, 11)
                }
        );

        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);

    }
}
