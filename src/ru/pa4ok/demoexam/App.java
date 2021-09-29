package ru.pa4ok.demoexam;

import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

public class App
{
    /*
        Book
        - String title (>3 & <20 символов)
        - String author (>3 & <20 символов)
        - int pages (>0)

        Library
        - String address
        - Book[] books
        - public void readBook() throws BookReadException, LibrarySpaceException
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
            //int[] arr = new int[2];
            //arr[3] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //int[] arr = new int[2];
            //arr[3] = 5;
            double d = 5 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //int[] arr = new int[2];
            //arr[3] = 5;
            double d = 5 / 0;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            //int[] arr = new int[2];
            //arr[3] = 5;
            double d = 5 / 0;
        } catch (Exception e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*try {
            test2(100);
        } catch (MyException e) {
            e.printStackTrace();
        }*/

        //test3(1000);

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите что-то: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);

        System.out.println("mark2");
    }

    public static void test() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void test2(int i) throws MyException {
        if(i > 50) {
            throw new MyException("dlkjweoifjwef");
        }
    }

    public static void test3(int i) {
        try {
            test2(i);
        } catch (MyException e) {
            throw new RuntimeException("egrgertgrege", e);
        }
    }
}

