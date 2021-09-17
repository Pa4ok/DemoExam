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
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

            Student
            - String fio
            - int age
            - int level //класс
            - public boolean nextYear() //age++ level++

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж
            - public boolean nextYear() //age++ exp++

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public int nextYearAll()
     */

    public static void main(String[] args)
    {
        School sc = new School(
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
        sc.nextYear();
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
