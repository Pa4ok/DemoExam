package ru.pa4ok.test;

/**
 * структура класса сверху вниз
 * 1 - поля класса
 * 2 - конструкторы (от большего к меньшему)
 * 3 - ваши методы класса
 * 4 - переопределенный вывод (toString) и тд
 * 5 - геттеры и сеттеры
 */
public class House
{
    /*
        public - достуно везде
        private - доступно только из этого же класса
        protected - ...
        default - доступно в рамках 1 пакета
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

    //переопределение вывода
    public String toString() {
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
        if(humanCount >= 0) {
            this.humanCount = humanCount;
        }
    }
}
