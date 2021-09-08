package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
        конструктор на все поля + toString
        все поля приватные + геттеры и сеттеры

        class Car
        - String type
        - int mileage
        - public void addMileage() +1 к mileage

        на метод установки поля mileage (сеттер) необходимо повесить проверку
        чтобы новое значение не могло быть меньше старого
         */

        Car car = new Car("wfgwewef", 2222);
        System.out.println(car);
        car.addMileage();
        car.addMileage();
        car.addMileage();
        System.out.println(car);
        car.setMileage(10);
        System.out.println(car);
        car.setMileage(10000);
        System.out.println(car);
    }
}
