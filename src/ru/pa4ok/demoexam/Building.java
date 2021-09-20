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

    public String getTitle() {
        return address;
    }

    public void setTitle(String title) {
        this.address = title;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
