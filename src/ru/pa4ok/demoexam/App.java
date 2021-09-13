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
        school.nextYear();
        System.out.println(school);
        school.nextYear();
        System.out.println(school);
        school.nextYear();
        System.out.println(school);
        school.nextYear();
        System.out.println(school);
    }
}

