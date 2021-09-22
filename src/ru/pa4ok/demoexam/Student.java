package ru.pa4ok.demoexam;

public class Student extends Human
{
    protected int level;

    public Student(String fio, char gender, int age, int level)
    {
        //вызов родительского конструктора Human
        super(fio, gender, age);
        this.level = level;
    }

    @Override
    public void test() {
        super.test();
        System.out.println("print from Student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", level=" + level +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
