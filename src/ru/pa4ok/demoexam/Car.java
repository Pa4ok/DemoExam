package ru.pa4ok.demoexam;

public class Car
{
    /*
        public - видно везде
        private - только в рамках своего класса
        protected = ...
        default - в рамках 1 пакета
     */

    private String type;
    private int mileage;

    public Car(String type, int mileage)
    {
        this.type = type;
        this.mileage = mileage;
    }

    public Car(String type)
    {
        this(type, 0);
    }

    public void testPublic() {
    }

    private void testPrivate() {
    }

    void testDefault() {
    }

    public void addMileage() {
        mileage++;
    }

    public String toString() {
        return "MyCar: " + type + " " + mileage;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if(mileage > this.mileage) {
            this.mileage = mileage;
        }
    }
}
