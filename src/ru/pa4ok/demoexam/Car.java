package ru.pa4ok.demoexam;

public class Car
{
    private static int idCounter;

    private int id;
    private String type;

    public Car(String type) {
        this.id = idCounter++;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
