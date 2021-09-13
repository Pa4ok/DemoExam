package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class App
{
    /*
        все поля в классах приватные + геттеры и сеттеры
        +конструктор на все поля и переопределенный вывод (toString)

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
        
        метод nextYear() означает то что в школе прошел еще 1 год

        всем студентам и преподаветелям необходимо увеличить возраст на 1
        студентам также необходимо увеличить класс на 1
        преподавателям также неонбходимо увеличить стаж на 1

        если после увеличения класса стундента он >11 его необхдимо удалить (заменить на null)
        и написать в консоль о том что он выпустился

        если после увеличения возраста преподавателя он >60 его необходимо удалить (заменить на null)
        и написать в консоль о том что он ушел на пенсию
     */

    public static void main(String[] args)
    {
        /*Book book = new Book("2fewfew312", "wefwefewf", 222);
        System.out.println(book);*/

        Book[] books = new Book[] {
                new Book("2fewfew312", "2efwefewf", 222),
                null,
                null
        };

        Library lib = new Library("owefgoifg", books);
        System.out.println(lib);

        System.out.println(lib.addBook(new Book("1", "2", 3)));
        System.out.println(lib.addBook(new Book("2", "2", 3)));
        System.out.println(lib.addBook(new Book("3", "2", 3)));
        System.out.println(lib);
        System.out.println(lib.removeBook("3"));
        System.out.println(lib.removeBook("2"));
        System.out.println(lib);
    }
}
