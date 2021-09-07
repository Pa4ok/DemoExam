package ru.pa4ok.demoexam;

public class Car
{
    private String type;
    private int mileage;

    public Car(String type, int mileage) {
        this.type = type;
        this.mileage = mileage;
    }

    public void addMileage() {
        this.mileage++;
    }

    public String toString() {
        return "MyCar: " + type + " " + mileage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if(mileage > this.mileage) {
            this.mileage = mileage;
        }
    }
}
