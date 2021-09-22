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
        /*Human h = new Human("h1", 'ж', 20);
        System.out.println(h);

        Student s = new Student("s1", 'ж', 20, 11);
        System.out.println(s);*/

        Human h = new Student("s1", 'ж', 20, 11);
        //Human h = new Teacher("t1", 'м', 30, "subj", 5);

        /*Student s = (Student) h;
        System.out.println(s.getLevel());
        s.setLevel(10);
        System.out.println(h);*/

        /*System.out.println(h instanceof Human);
        System.out.println(h instanceof Teacher);
        System.out.println(h instanceof Student);*/

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            System.out.println("teacher: " + t);
        } else if(h instanceof Student) {
            Student s = (Student) h;
            System.out.println("student: s");
        } else {
            System.out.println(h);
        }
    }

    public static void updateSchoolEntity(Human h) {
        h.age++;
        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            t.exp++;
        } else if(h instanceof Student) {
            Student s = (Student) h;
            s.level++;
        }
    }
}
