package ru.pa4ok.demoexam;

import java.util.Arrays;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
        abstract Sortinger
        - public abstract void sort(int[] arr)
        - public long sortWithTime(int[] arr)

        sortWithTime сохранять время до сортировки
        вызывать метод сортировки
        считать потраченное время и возвращать его

        BubbleSortinger extends Sortinger
        - public void sort(int[] arr) //реализация для конкретного алгоритма

        +2-3 класса с другими алгоритмами сортировки
        https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
        //вы не можете напрямую создать объект абстрактного класса
        //Human h = new Human();

        //анонимный класс
        //реализация в рамках только 1 объекта
        Human h = new Human() {
            @Override
            public void test() {
                System.out.println("wohiowef");
            }
        };

        //текущее время в милисекундах
        long mills = System.currentTimeMillis();
    }
}

abstract class Human
{
    //абстрактная функцию без тела
    public abstract void test();
}

//наследники абстрактного класса либо тоже должны быть абстрактными
abstract class Teacher extends Human
{

}

//либо должны реализовывать все абстрактные функции
class Student extends Human
{
    @Override
    public void test() {
        System.out.println("123312");
    }
}
