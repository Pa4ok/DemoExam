package ru.pa4ok.demoexam;

public class Student
{
    public String fio;
    public int level;
    public int test1;
    public int test2;
    public int test3;
    public int test4;

    public Student(String fio, int level) {
        this.fio = fio;
        this.level = level;
        this.test1 = level++;
        this.test2 = test1++;
        this.test3 = test2++;
        this.test4 = test3++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", level=" + level +
                '}';
    }
}
