package ru.pa4ok.demoexam;

public class Human
{
    //статичная и финальная переменная - константа
    public static final String TEST_STATIC_FINAL_FIELD = "123123wfewefwe";
    public static final String TEST;

    static {
        //обязаны ее объявить либо сразу, либо в static блоке
        TEST = "123fwef";
    }

    protected String fio;
    protected final char gender;
    protected int age;

    public Human(String fio, char gender, int age) {
        this.fio = fio;
        this.gender = gender;
        this.age = age;
    }

    //такой метод нельзя будет переопределить
    public final void test() {
    }

    public boolean nextYear() {
        age++;
        return true;
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

    //public void setGender(char gender) {
    //    this.gender = gender;
    //}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
