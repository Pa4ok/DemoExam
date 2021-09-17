package ru.pa4ok.demoexam;

public class Car
{
    static {
        System.out.println("class Car loaded");
    }

    public static int staticField = 5;
    public String type;

    public Car(String type) {
        this.type = type;
    }

    public static void staticMethod() {
        System.out.println(staticField + " 12343fe;pogr");

    }

    public void test() {
        System.out.println(staticField);
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                '}';
    }
}
