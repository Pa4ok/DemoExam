package ru.pa4ok.demoexam;

import ru.pa4ok.test.House;

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
            class ru.pa4ok.test.House +конструктор со всеми полями
            - String address
            - ing floorCount
            - int humanCount
            - public void print()

            Main/ru.pa4ok.demoexam.App/главный класс
            создать в main методе объект ru.pa4ok.test.House

            создать в главном классе 2 функции: addHuman(ru.pa4ok.test.House house) и removeHuman(ru.pa4ok.test.House house)
            увеличивать или уменьшать количество людей в объекте house из аргументов на 1
         */

        /*House h = new House("dfjq2wf", 5, 15);
        h.print();
        for(int i=0; i<10; i++) {
            addHuman(h);
        }
        h.print();*/

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
    }

    public static void addHuman(House h)
    {
        h.setHumanCount(h.getHumanCount() + 1);
    }

    public static void removeHuman(House h)
    {
        h.setHumanCount(h.getHumanCount() - 1);
    }
}
