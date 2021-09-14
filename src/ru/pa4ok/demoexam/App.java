package ru.pa4ok.demoexam;

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
            все поля приватные + геттеры и сеттеры
            констуктор + переопределнный вывод (toString)

            House
            - String address
            - int floorCount
            - int humanCount
            - public void addHuman() ++ для humanCount
            - public void removeHuman() -- для humanCount

            для методов removeHuman() и setHumanCount() необходимо сделать проверку
            чтобы нельзя было сделать отрицательное количество человек
         */

        Car pizo = new Car("pwoeifwhfwef", 12233);
        System.out.println(pizo.getType() + " " + pizo.getMileage());
        pizo.setMileage(-100);
        System.out.println(pizo.getType() + " " + pizo.getMileage());
    }
}
