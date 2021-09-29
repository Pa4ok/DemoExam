package ru.pa4ok.demoexam;

import java.util.Random;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с доступными методами и полями объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, геттеры, сеттеры, toString...)
 */

public class Application
{
    /*
        Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - Book[] books
        - public void readBook()
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - Book book
     */

    public static void main(String[] args)
    {
        System.out.println("mark1");

        /*try {
            int[] arr = new int[3];
            arr[4] = 5;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //*int[] arr = new int[3];
            //arr[4] = 5;
            double d = 4 / 0;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //int[] arr = new int[3];
            //arr[4] = 5;
            double d = 4 / 0;

        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //int[] arr = new int[3];
            //arr[4] = 5;
            double d = 4 / 0;

        } catch (Exception e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*Random rand = new Random();
        int i = rand.nextInt(500);
        if(i < 250) {
            throw new MyRuntimeException("123oefdghoprg");
        }

        System.out.println("mark2");*/

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = Integer.parseInt(scanner.nextLine());
    }

    public static void test()
    {
        //...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //...
    }

    public static void test1() throws InterruptedException{
        //...
        Thread.sleep(1000);
        //...
    }

    public static void test2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("wefiuwefgfew", e);
        }
    }
}
