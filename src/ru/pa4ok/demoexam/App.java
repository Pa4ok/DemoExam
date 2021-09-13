package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

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

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public void nextYear()

            метод nextYear обозначет то что в школе прошел 1 год
            данный метод должен увеличивать возраст всех учителей и студентов на 1
            также он должен увеличить у них класс и стаж на 1

            если после увеличения класса студента он > 11 то его надо убрать из школы (заменить на null)
            и вывести информацию в консоль о том что он выпустился

            если после увеличения возраста преподавателя он > 60 то его надо убрать из школы (заменить на null)
            и вывести информацию в консоль о том что он ушел на пенсию
     */

    public static void main(String[] args)
    {
        Library lib = new Library("dwqeqwdqwdd", new Book[] {
                null,
                new Book("t1", "a1", 1),
                new Book("t2", "a2", 2),
                null,
                new Book("t3", "a3", 3),
                new Book("t4", "a4", 4),
                new Book("t5", "a5", 5)
        });

        System.out.println(lib);
        System.out.println(lib.addBook(new Book("t6", "a6", 6)));
        System.out.println(lib.addBook(new Book("t7", "a7", 6)));
        System.out.println(lib.addBook(new Book("t8", "a8", 6)));
        System.out.println(lib);
        System.out.println(lib.removeBook("t3"));
        System.out.println(lib.removeBook("t8"));
        System.out.println(lib);


    }
}

