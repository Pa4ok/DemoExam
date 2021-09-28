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
        Human
        - String fio
        - char gender
        - int age

        Student extends Human
        - int level

        Teacher extends Human
        - String subject
        - int exp

        Building
        - String address
        - int floorCount

        School extends Building
        - Human[] entities
        - public void nextYear()

        метод nextYear() должен перебирать всех обиталей школы и увеличивать им возраст на 1
        если обитатель является Student увеличить на 1 level
        если обитатель является Teacher увеличить на 1 exp
        если level > 11 или age > 60 его необходимо выгнать (заменить на null в массиве)
        если обитатель не является ни Student, ни Teacher его необходимо сразу заменить на null
        и вывести информацию в консоль

     */


    public static void main(String[] args)
    {
        School sc = new School(
                "wefoihweofhwef", 5,
                new Human[] {
                        new Teacher("t1", 'w', 55, "subj", 20),
                        new Teacher("t2", 'w', 58, "subj", 20),
                        new Teacher("t3", 'w', 58, "subj", 20),
                        new Student("s1", 'w', 20, 7),
                        null,
                        new Human("h1", 'm', 30),
                        new Student("s1", 'w', 20, 9),
                        new Student("s1", 'w', 20, 10),
                        new Teacher("t4", 'w', 60, "subj", 20)
                }
        );

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
        sc.nextYear();
        System.out.println();

        System.out.println(sc);
    }
}

