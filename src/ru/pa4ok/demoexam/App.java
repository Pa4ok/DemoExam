package ru.pa4ok.demoexam;

import ru.pa4ok.test.House;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 */

public class App
{
    public static void main(String[] args)
    {
        House h = new House("efewffewfwe", 5, 20);
        /*System.out.println(h);
        h.addHuman();
        System.out.println(h);
        for(int i=0; i<30; i++) {
            h.removeHuman();
        }
        System.out.println(h);*/
        System.out.println(h.getAddress() + " " + h.getFloorCount() + " " + h.getHumanCount());
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


