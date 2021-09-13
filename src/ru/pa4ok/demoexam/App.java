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

        House h = new House("wefojjwfiuf", 5, 15);
        System.out.println(h.getAddress() + " " + h.getFloorCount() + " " + h.getHumanCount());
        h.setHumanCount(-100);
        System.out.println(h.getAddress() + " " + h.getFloorCount() + " " + h.getHumanCount());
    }
}

