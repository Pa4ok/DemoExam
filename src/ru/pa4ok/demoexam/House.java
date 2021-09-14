package ru.pa4ok.demoexam;

/**
 * поля класса
 * конструкторы (от большего к меньшему)
 * методы класса
 * переопределенные методы (toString...)
 * геттеры и сеттеры
 */
public class House
{
    private String address;
    private int floorCount;
    private int humanCount;

    public House(String address, int floorCount, int humanCount)
    {
        this.address = address;
        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    public House(String address, int floorCount)
    {
        this(address, floorCount, 100);
    }

    public void addHuman()
    {
        humanCount++;
    }

    public void removeHuman()
    {
        if(humanCount > 0) {
            humanCount--;
        }
    }

    public String toString() {
        return "MyHouse: " + address + " " + floorCount + " " + humanCount;
    }

    public String getAddress() {
        return this.address;
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
        this.humanCount = humanCount;
    }
}
