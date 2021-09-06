package ru.pa4ok.demoexam;

/**
 * константы
 * обычные поля
 * конструкторы (от самого большого (по аргументам) к самому маленькому)
 * методы обычные
 * методы переопределнные
 * геттеры и сеттеры
 */
public class House
{
    private String address;
    private int floorCount;
    private int humanCount;

    //constructor(String,int,int)
    public House(String address, int floorCount, int humanCount)
    {
        this.address = address;
        if(this.address.startsWith("spb")) {
            this.address.replace("spb", "msk");
        }

        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    //constructor(String,int)
    /*public House(String address, int floorCount)
    {
        this.address = address;
        this.floorCount = floorCount;
    }*/

    //вызов одного конструктора из другого
    public House(String address, int floorCount)
    {
        this(address, floorCount, 0);
    }

    //переопределение вывода
    public String toString() {
        return "MyHouse: " + this.address + " " + this.floorCount + " " + this.humanCount;
    }

    public void addHuman() {
        this.humanCount++;
    }

    public void removeHuman() {
        if(this.humanCount > 0) {
            this.humanCount--;
        }
    }

    public void print()
    {
        System.out.println("MyHouse: " + address + " " + floorCount + " " + humanCount);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getHumanCount() {
        return humanCount;
    }

    public void setHumanCount(int humanCount) {
        if(humanCount >= 0) {
            this.humanCount = humanCount;
        }
    }
}
