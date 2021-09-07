package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 */

public class App
{
    public static void main(String[] args)
    {
        Car car = new Car("qwef'jwfe", 100);
        System.out.println(car);
        car.addMileage();
        car.addMileage();
        car.addMileage();
        System.out.println(car);
        car.setMileage(10);
        System.out.println(car);
        car.setMileage(1000);
        System.out.println(car);
    }

    /*
        все поля приватные
        конструктор на все необходимые поля
        переопределенный вывод (toString)
        геттеры и сеттеры

        class Car
        - String type
        - int mileage
        - public void addMileage() ++

        на сеттер для поля mileage нужно повесить проверку
        чтобы новое значение не могло быть меньше старого
     */
}


