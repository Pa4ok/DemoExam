package ru.pa4ok.demoexam.school;

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

    public boolean nextYear()
    {
        age++;
        level++;
        if(level > 11) {
            return true;
        }
        return false;
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

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
