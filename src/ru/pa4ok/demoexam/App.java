package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class App
{
     /*
        Human
        - String fio
        - char gender
        - int age
        - public boolean nextYear() //age++ return true

        Student extends Human
        - int level
        - public boolean nextYear() //вызывает родителькую реализацию, level++, return level > 11

        Teacher extends Human
        - String subject
        - int exp
        - public boolean nextYear() //вызывает родителькую реализацию, exp++, return age > 60

        Building
        - String address
        - int floorCount

        School extends Building
        - String title
        - Human[] entities
        - public int nextYearAll()

        метод nextYearAll() должен перебирать всех обиталей школы и вызывать у них метод nextYear
        если он возвращает true данного участника необходимо удалить из школы (заменить на null)
        возвращает метод количество людей покинувших школу на этом этапе

     */

    public static void main(String[] args)
    {
        /*Teacher[] teachers = new Teacher[] {
                new Teacher("t1", 55, "s1", 10),
                null,
                new Teacher("t2", 58, "s2", 11),
                new Teacher("t3", 59, "s3", 12)
        };

        Student[] students = new Student[] {
                new Student("s1", 15, 8),
                null,
                new Student("s2", 15, 9),
                new Student("s3", 15, 9),
                new Student("s4", 15, 11)
        };

        School school = new School("fojweoiwf", teachers, students);
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);
        System.out.println(school.nextYearAll());
        System.out.println(school);*/

        /*Human h = new Human("h1", 'm', 22);
        Student s = new Student("s1", 'w', 20, 11);

        h.test();
        System.out.println("==============");
        s.test();

        System.out.println();
        System.out.println(s);*/

        //Human h = new Student("s1", 'w', 20, 11);
        Human h = new Teacher("t1", 'w', 40, "dwwqdwq", 20);

        /*System.out.println(h);
        Student s = (Student) h;
        s.setLevel(20);
        System.out.println(h);*/

        /*System.out.println(h instanceof Human);
        System.out.println(h instanceof Student);
        System.out.println(h instanceof Teacher);*/

        if(h instanceof Teacher) {
            Teacher t = (Teacher) h;
            t.setExp(10);
        } else if(h instanceof Student) {
            Student s = (Student) h;
            s.setLevel(10);
        }
    }

    public static void increment(Human h)
    {
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
