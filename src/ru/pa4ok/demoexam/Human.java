package ru.pa4ok.demoexam;

public class Human
{
    static {
        System.out.println("class Human loaded");
    }

    public static int staticField = 5;

    public String fio;

    public Human(String fio) {
        this.fio = fio;
    }

    public static void staticMethod() {
        System.out.println("test static " + staticField);
    }

    public void test() {
        staticField++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
