package ru.pa4ok.demoexam;

public class Human
{
    public static int staticField = 5;

    static {
        System.out.println("Human cls loaded");
    }

    public String fio;

    public Human(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Human{" +
                "fio='" + fio + '\'' +
                '}';
    }

    public void test() {
        System.out.println("test " + staticField);

    }

    public static void staticTest() {
        System.out.println("static test");
    }
}
