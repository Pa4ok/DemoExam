package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*
            создать пакет для своей приложухи по образу
            все поля приватные + геттеры и сеттеры к ним + конструктор на все аргументы

            class Car
            - String type
            - int mileage
            - public void print()

            + конструктор только с типом машины (пробег 0)
            в сеттере на mileage сделать проверку на то что новое значение не меньше старого
         */

        Car car = new Car("wdqw'kwqo[pd");
        car.print();
        car.setMileage(10);
        car.print();
        car.setMileage(20);
        car.print();
        car.setMileage(5);
        car.print();
        car.setMileage(100);
        car.print();
    }
}
