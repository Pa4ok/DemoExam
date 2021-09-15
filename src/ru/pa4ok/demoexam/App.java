package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
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

        Book[] books = new Book[] {
                null,
                new Book("1", "1", 1),
                null,
                null,
                null,
                new Book("2", "2",2),
                null,
                null,
                new Book("3", "3",3)
        };

        Library lib = new Library("wqadqw[odiqwd", books);
        System.out.println(lib);
        lib.addBook(new Book("4", "4",4));
        lib.addBook(new Book("5", "5",5));
        lib.addBook(new Book("6", "6",6));
        System.out.println(lib);
        System.out.println(lib.removeBook("5", "5"));
        System.out.println(lib.removeBook("5", "wefwefewffe"));
        System.out.println(lib);
    }
}

