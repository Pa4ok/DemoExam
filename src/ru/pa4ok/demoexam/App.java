package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

            Student
            - String fio
            - int age
            - int level //класс
            - public boolean nextYear()

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж
            - public boolean nextYear()

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public int nextYearAll()

            метод nextYear в Student/Teacher увеличивает необходимые на 1
            и возврает true если стундент выпустился (level > 11) или преподаватель ушел на пенсию (age > 60)

            метод nextYearAll в School перебирает всех стундентов и преподавателей и вызывает у них метод nextYear
            возврает он количество человек покинувших школу за вызов
     */

    public static void main(String[] args)
    {
        School school = new School(
                "wdqdqwdwdqwqd",
                new Teacher[]{
                        new Teacher("t1", 55, "a", 10),
                        null,
                        new Teacher("t2", 58, "a", 10),
                        new Teacher("t3", 60, "a", 10)

                },
                new Student[] {
                        null,
                        new Student("s1", 15, 11),
                        new Student("s2", 15, 10),
                        new Student("s3", 15, 10),
                        new Student("s4", 15, 7)
                }
        );

        System.out.println(school);
        System.out.println(school.nextYear());
        System.out.println(school);
        System.out.println(school.nextYear());
        System.out.println(school);
        System.out.println(school.nextYear());
        System.out.println(school);
        System.out.println(school.nextYear());
        System.out.println(school);
    }
}

