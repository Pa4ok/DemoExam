package ru.pa4ok.demoexam;

public class Human
{
    protected String fio;
    protected char gender;
    protected int age;

    public Human(String fio, char gender, int age) {
        this.fio = fio;
        this.gender = gender;
        this.age = age;
    }

    public void test() {
        System.out.println("print from Human");
    }

    @Override
    public String toString() {
        return "Human{" +
                "fio='" + fio + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}