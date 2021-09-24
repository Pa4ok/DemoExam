package ru.pa4ok.demoexam;

public class Building
{
    protected String address;
    protected int floorCount;

    public Building(String address, int floorCount) {
        this.address = address;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", floorCount=" + floorCount +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public Building setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public Building setFloorCount(int floorCount) {
        this.floorCount = floorCount;
        return this;
    }
}
