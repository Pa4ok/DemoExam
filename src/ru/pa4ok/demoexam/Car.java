package ru.pa4ok.demoexam;

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

    public void print()
    {
        System.out.println("MyCar: " + this.type + " " + this.mileage);
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
