package ru.pa4ok.demoexam;

public class Student
{
    private String fio;
    private int age;
    private int level;

    public Student(String fio, int age, int level) {
        this.fio = fio;
        this.age = age;
        this.level = level;
    }

    public boolean nextYear() {
        age++;
        level++;
        return level > 11;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public Student setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Student setLevel(int level) {
        this.level = level;
        return this;
    }
}
