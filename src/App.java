import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            констуктор + переопределнный вывод (toString)

            class House
            - String address
            - int floorCount
            - int humanCount
            - public void addHuman() ++ для humanCount
            - public void removeHuman() -- для humanCount

            для метода removeHuman необходимо сделать проверку
            чтобы нельзя было сделать отрицательное количество человек
         */

        Car pizo = new Car("pwoeifwhfwef", 12233);
        System.out.println(pizo);
        pizo.addMileage();
        pizo.addMileage();
        pizo.addMileage();
        System.out.println(pizo);
    }
}

class Car
{
    String type;
    int mileage;

    public Car(String type, int mileage)
    {
        this.type = type;
        this.mileage = mileage;
    }

    public void addMileage() {
        mileage++;
    }

    public String toString() {
        return "MyCar: " + type + " " + mileage;
    }
}
