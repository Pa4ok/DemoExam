package ru.pa4ok.demoexam;

import ru.pa4ok.test.House;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - вызов контекстного меню по исправлению ошибки
 * cntl + space - вызов контекстного меню с доступными методами и полями объекта (после точки)
 */

public class Application {
    public static void main(String[] args) {
        House house = new House("adkqwpjdfo0qwd", 4, 14);
        house.print();
        for(int i=0; i<10; i++) {
            addHuman(house);
        }
        house.print();

        //int[] arr = {1, 2, 3};
        //System.out.println(Arrays.toString(arr));

        /*
            пока что во всех наших классах все поля будут приватными
            +должны быть публичные геттеры и сеттеры для взаимодействия с ними

            Car
            - String type
            - int mileage
            - public void print()

            создать объект класа с приватными полями, публичными геттерами и сеттарми
            на сеттере для mileage необходимо реализовать проверку на то что новое значение не должно быть меньше старого
            если же оно меньше выводить информацию об этом в консоль
         */
    }

    public static void addHuman(House house)
    {
        //house.humanCount++;
        house.setHumanCount(house.getHumanCount() + 1);
    }

    public static void removeHuman(House house)
    {
        //house.humanCount--;
        house.setHumanCount(house.getHumanCount() - 1);
    }
}
