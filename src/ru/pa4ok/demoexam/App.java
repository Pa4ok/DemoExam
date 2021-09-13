package ru.pa4ok.demoexam;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            конструктор, переопределенный вывод (toString)
            все поля приватные + геттеры и сеттеры

            Car
            - String type
            - int mileage
            - public void addMileage() // увиличение mileage на 1

            на сеттере для mileage необходимо реализовать проверку
            чтобы новое значение не было меньше предыдущего
         */

        Car car = new Car("wefgwegfewf", 10);
        System.out.println(car);
        car.addMileage();
        car.addMileage();
        car.addMileage();
        System.out.println(car);
        car.setMileage(100);
        System.out.println(car);
        car.setMileage(1);
        System.out.println(car);
        car.setMileage(1000);
        System.out.println(car);
    }
}

