package ru.pa4ok.demoexam;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
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

            если после увеличения возраста преподавателя он > 70 то его надо убрать из школы (заменить на null)
            и вывести информацию в консоль о том что он ушел на пенсию
     */


    public static void main(String[] args)
    {
        Library lib = new Library(
                "we;fjhewoifew",
                new Book[]{
                        null,
                        new Book("book1", "author1", 100),
                        new Book("book2", "author2", 100),
                        null,
                        new Book("book3", "author3", 100),
                        new Book("book4", "author4", 100),
                        new Book("book5", "author5", 100)
                }
        );
        System.out.println(lib);
        System.out.println(lib.removeBook("book4", "author4"));
        System.out.println(lib);
    }
}

