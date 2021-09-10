package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.lib.Book;
import ru.pa4ok.demoexam.lib.Library;
import ru.pa4ok.demoexam.school.School;
import ru.pa4ok.demoexam.school.Student;
import ru.pa4ok.demoexam.school.Teacher;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
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
        School school = new School(
                "woefjifeqeff",
                new Teacher[] {
                        new Teacher("t1", 50, "1", 1),
                        new Teacher("t2", 55, "2", 2),
                        null,
                        new Teacher("t3", 59, "3", 3),
                },
                new Student[] {
                        new Student("s1", 1, 5),
                        new Student("s2", 2, 8),
                        new Student("s3", 3, 8),
                        null,
                        new Student("s4", 4, 1),
                        new Student("s5", 5, 11)
                }
        );

        System.out.println("==============0");
        System.out.println(school);
        school.nextYear();
        System.out.println("==============1");
        System.out.println(school);
        school.nextYear();
        System.out.println("==============2");
        System.out.println(school);
        school.nextYear();
        school.nextYear();
        school.nextYear();
        System.out.println("==============3");
        System.out.println(school);
    }
}