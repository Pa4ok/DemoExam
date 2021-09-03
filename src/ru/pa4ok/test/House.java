package ru.pa4ok.test;

public class House
{
    /*
        модификаторы доступа
        public - видно везде
        private - видно только в этом классе
        protected - видно у наследноков и в 1 пакете
        default - видено в 1 пакете

     */

    private String address;
    private int floors;
    private int humanCount;

    public House(String address, int floors, int humanCount)
    {
        this.address = address;
        this.floors = floors;
        this.humanCount = humanCount;
    }

    public void print()
    {
        System.out.println("MyHouse: " + address + " " + floors + " " + humanCount);
    }

    /*public void testPublic() {
    }

    private void testPrivate() {
    }

    void testDefault() {
    }*/

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHumanCount() {
        return this.humanCount;
    }

    public void setHumanCount(int humanCount) {
        if(humanCount > 0) {
            this.humanCount = humanCount;
        } else {
            System.out.println("вы попытались установить неверное количетсво страниц");
        }
    }
}
