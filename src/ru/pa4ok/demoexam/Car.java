package ru.pa4ok.demoexam;

/**
 * поля класса
 * конструторы (от большего к меньшему)
 * методы класса
 * переопределение базовых функций (вывод...)
 * геттеры и сеттеры
 */
public class Car
{
    private String type;
    private int mileage;

    public Car(String type, int mileage)
    {
        this.type = type;
        this.mileage = mileage;
    }

    public Car(String type)
    {
        this(type, 0);
    }

    //переопределение вывода
    public String toString() {
        return "MyCar: " + this.type + " " + this.mileage;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        if(this.mileage < mileage) {
            this.mileage = mileage;
        } else {
            System.out.println("га га га");
        }
    }
}
