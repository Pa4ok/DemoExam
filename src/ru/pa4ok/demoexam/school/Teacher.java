package ru.pa4ok.demoexam.school;

public class Teacher
{
    private String fio;
    private int age;
    private String subject;
    private int exp;

    public Teacher(String fio, int age, String subject, int exp) {
        this.fio = fio;
        this.age = age;
        this.subject = subject;
        this.exp = exp;
    }

    public boolean nextYear() {
        age++;
        exp++;
        return age > 60;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public Teacher setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Teacher setAge(int age) {
        this.age = age;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Teacher setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public int getExp() {
        return exp;
    }

    public Teacher setExp(int exp) {
        this.exp = exp;
        return this;
    }
}

