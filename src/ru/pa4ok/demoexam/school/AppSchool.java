package ru.pa4ok.demoexam.school;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class AppSchool
{
     /*
            пока что во всех наших классах все поля будут приватными
            +должны быть публичные геттеры и сеттеры для взаимодействия с ними

            Student
            - String fio
            - int age
            - int level //класс
            - public boolean nextYear()
                age++ level++
                возврает true если после увеличения level > 11

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж
            - public boolean nextYear()
                age++ exp++
                возврает true если после увеличения age > 60

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public int nextYearAll()

            метод nextYear обозначет то что в школе прошел 1 год
            он перебирает всех студентов и преподавателей и вызывает у них методы nextYear

            если вызывнный у стундента или преподавателя метод nextYear возвращает true
            то студента или преподавателя необходимо выпустили или отправить на пенсию

            возвращаем значением самого метода будет int - количество людей покинувших школу на этом этапе
     */

    public static void main(String[] args)
    {
        Teacher[] teachers = new Teacher[] {
                new Teacher("t1", 55, "s1", 10),
                null,
                new Teacher("t2", 58, "s2", 11),
                new Teacher("t3", 59, "s3", 12)
        };

        Student[] students = new Student[] {
                new Student("s1", 15, 8),
                null,
                new Student("s2", 15, 9),
                new Student("s3", 15, 9),
                new Student("s4", 15, 11)
        };

        School school = new School("fojweoiwf", teachers, students);
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
    }
}
