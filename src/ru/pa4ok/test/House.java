package ru.pa4ok.test;

/*
    поля класса
    конструторы от большего к меньшему
    методы класса
    переопределенные базовые методы (toString...)
    геттеры и сеттеры
 */
public class House
{
    /*
        public - видно везде
        private - видно только в этом же классе
        protected - ...
        default - в рамках 1 пакета
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

    public void addHuman() {
        this.humanCount++;
    }

    public void removeHuman() {
        if(this.humanCount > 0) {
            this.humanCount--;
        }
    }

    public void testPublic() {
    }

    private void testPrivate() {
    }

    void testDefault() {
    }

    public String toString()
    {
        return "MyHouse: " + this.address + " " + this.floorCount + " " + this.humanCount;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloorCount() {
        return this.floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getHumanCount() {
        return this.humanCount;
    }

    public void setHumanCount(int humanCount) {
        this.humanCount = humanCount;
    }
}
