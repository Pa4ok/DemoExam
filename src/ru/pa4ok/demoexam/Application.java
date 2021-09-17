package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
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

     */

    public static void main(String[] args)
    {
        /*Human h = new Human("h1", 'ж', 40);
        System.out.println(h);

        Teacher t = new Teacher("t1", 'м', 55, "s1", 10);
        System.out.println(t);
    */

        /*Human h = new Teacher("t1", 'м', 55, "s1", 10);
        System.out.println(h);
        System.out.println(h.getClass());
        Teacher t = (Teacher) h;
        System.out.println(t.subject + " " + t.exp);*/

        Human h = new Student("t1", 'м', 55, 10);
        System.out.println(h);
        System.out.println(h instanceof Human);
        System.out.println(h instanceof Student);
        System.out.println(h instanceof Teacher);

        if(h instanceof Student) {
            Student s = (Student)h;
            System.out.println("test student: " + s.level);
        }

        //java 16+
        if(h instanceof Student s) {
            System.out.println("test student: " + s.level);
        }
    }

    public static void testSchoolEntity(Human h)
    {
        h.age++;

        if(h instanceof Student s) {
            s.level++;
        }

        if(h instanceof Teacher t) {
            t.exp++;
        }
    }
}