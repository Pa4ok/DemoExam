package ru.pa4ok.demoexam;

public class Teacher extends Human
{
    protected String subject;
    protected int exp;

    public Teacher(String fio, char gender, int age, String subject, int exp) {
        super(fio, gender, age);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void test() {
        super.test();
        System.out.println("test form Teacher");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fio='" + fio + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                '}';
    }
}
