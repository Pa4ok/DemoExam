package ru.pa4ok.demoexam;

public class Teacher extends Human
{
    protected String subject;
    protected int exp;

    public Teacher(String fio, char gender, int age, String subject, int exp) {
        //вызов родительского конструтора
        super(fio, gender, age);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void test() {
        System.out.println("test from Teacher");
        super.test();
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}

