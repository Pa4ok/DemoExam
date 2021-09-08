package ru.pa4ok.demoexam;

import ru.pa4ok.test.House;

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

        House h = new House("dwqpdjqid", 12, 10);
        //System.out.println(h.address + " " + h.floorCount + " " + h.humanCount);
        /*System.out.println(h.getAddress() + " " + h.getFloorCount() + " " + h.getHumanCount());
        h.setHumanCount(-100);
        System.out.println(h.getAddress() + " " + h.getFloorCount() + " " + h.getHumanCount());*/
        System.out.println(h);
    }
}
