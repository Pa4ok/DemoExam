package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.Student;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
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
        - String title
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
                "oqliwduhqwdud", 5,
                new Human[] {
                        null,
                        new Teacher("t1", 'ж', 55, "subject", 10),
                        new Teacher("t2", 'ж', 58, "subject", 10),
                        new Teacher("t3", 'ж', 59, "subject", 10),
                        new Student("s1", 'м', 20, 10),
                        new Student("s2", 'м', 20, 10),
                        null,
                        new Student("s3", 'м', 20, 11)
                }
        );

        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
        System.out.println(sc.nextYear());
        System.out.println(sc);
    }
}
