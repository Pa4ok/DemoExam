package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

public class App
{
     /*
            пока что во всех наших классах все поля будут приватными
            +должны быть публичные геттеры и сеттеры для взаимодействия с ними

            Student
            - String fio
            - int age
            - int level //класс
            - public boolean nextYear()
                age++ level++
                возврает true если после увеличения level > 11

            Teacher
            - String fio
            - int age
            - String subject
            - int exp //стаж
            - public boolean nextYear()
                age++ exp++
                возврает true если после увеличения age > 60

            School
            - String address
            - Teacher[] teachers
            - Student[] students
            - public int nextYearAll()

            метод nextYear обозначет то что в школе прошел 1 год
            он перебирает всех студентов и преподавателей и вызывает у них методы nextYear

            если вызывнный у стундента или преподавателя метод nextYear возвращает true
            то студента или преподавателя необходимо выпустили или отправить на пенсию

            возвращаем значением самого метода будет int - количество людей покинувших школу на этом этапе
     */

    public static void main(String[] args)
    {

    }
}

