package ru.pa4ok.test;

public class House
{
    /*
        области видимоти полей/методов
        public - достопно везде
        private - доступно только в рамках этого же класса
        protected - ... (позже_
        default - в рамках одного пакета
     */

    private String address;
    private int floorCount;
    private int humanCount;

    public House(String address, int floorCount, int humanCount) {
        this.address = address;
        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    public void print()
    {
        System.out.println("MyHouse: " + this.address + " " + this.floorCount + " " + humanCount);
    }

    public int getHumanCount() {
        return this.humanCount;
    }

    public void setHumanCount(int humanCount) {
        if(humanCount >= 0) {
            this.humanCount = humanCount;
        } else {
            System.out.println("га га га");
        }
    }
}
