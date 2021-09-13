package ru.pa4ok.demoexam;

public class House
{
    /*
        public - видно везде
        private - только в рамках этого класса
        protected - ...
        default - в рамках одного пакета
     */

    private String address;
    private int floorCount;
    private int humanCount;

    public House(String address, int floorCount, int humanCount)
    {
        this.address = address;
        this.floorCount = floorCount;
        this.humanCount = humanCount;
    }

    public void testPublic() {
    }

    private void testPrivate() {
    }

    void testDefault() {
    }

    public void addHuman() {
        humanCount++;
    }

    public void removeHuman() {
        if(humanCount > 0) {
            humanCount--;
        }
    }

    public String toString() {
        return "MyHouse: " + this.address + " " + this.floorCount + " " + this.humanCount;
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
