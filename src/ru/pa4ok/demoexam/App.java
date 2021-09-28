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
        /*School sc = new School(
                "wefoihweofhwef",
                new Teacher[] {
                        new Teacher("t1", 55, "subj", 20),
                        new Teacher("t2", 58, "subj", 20),
                        new Teacher("t3", 58, "subj", 20),
                        null,
                        new Teacher("t4", 60, "subj", 20)
                },
                new Student[]{
                        null,
                        new Student("s1", 20, 7),
                        null,
                        new Student("s1", 20, 9),
                        new Student("s1", 20, 10)
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
        System.out.println(sc);*/

        /*Human h1 = new Human("h1", 'w', 20);
        Student s1 = new Student("s1", 'm', 30, 11);

        System.out.println(h1);
        System.out.println(s1);
        h1.test();
        System.out.println();
        s1.test();*/

        //Human h = new Student("s1", 'm', 30, 11);
        Human h = new Teacher("t1", 'w', 50,"subj", 20);

        /*System.out.println(h);
        Student s = (Student) h;
        s.age++;
        s.level++;
        System.out.println(h);*/

        System.out.println(h instanceof Human);
        System.out.println(h instanceof Teacher);
        System.out.println(h instanceof Student);

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            System.out.println("detect teacher");
        } else if(h instanceof Student) {
            Student s = (Student) h;
            System.out.println("detect student");
        }
    }

    public static void test(Human h)
    {
        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            t.exp += 10;
        } else if(h instanceof Student) {
            Student s = (Student) h;
            s.level += 10;
        } else {
            //...
        }
    }
}

