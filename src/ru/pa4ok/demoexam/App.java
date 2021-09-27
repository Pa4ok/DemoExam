package ru.pa4ok.demoexam;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App
{
    /*
        Point
        - double x
        - double z

        Figure
        - String title
        - Point[] points
        - public double calculateSquare() //return -1

        Triangle
        - конструктор на 3 точки, передает массив из них в родительский конструкор
        - public double calculateSquare() //считает уже по формуле для триугольника

        Rectangle
        - конструктор на 4 точки, передает массив из них в родительский конструкор
        - public double calculateSquare() //считает уже по формуле для прямоугольника
     */


    public static void main(String[] args)
    {
        Triangle t1 = new Triangle(
                new Point(0, 0),
                new Point(0, 10),
                new Point(10, 0)
        );

        System.out.println(t1.calculateSquare());
    }
}
