package ru.pa4ok.demoexam;

public class Student
{
    public static int testStaticField = 5;

    //при 1 обращении к классу он загружается в систему
    //и вызывается статичный блок
    static {
        System.out.println("class Student loaded");
    }

    public String fio;
    public int level;

    public Student(String fio, int level) {
        this.fio = fio;
        this.level = level;
    }

    //можно обращаться из обычного контекста в статичный
    public void test() {
        System.out.println(testStaticField);
    }

    //но нельзя из статичного в обычный, так как нет никакого объекта
    public static void testStaticMethod() {
        //System.out.println(fio);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", level=" + level +
                '}';
    }
}
