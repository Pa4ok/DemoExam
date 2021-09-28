package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
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
        - public void readBook()
            метод должен запрашивать у пользователя все поля книги и создавать из них ее объект после чего добавлять в библиотеку
            если пользователь вводит неверные значения выбрасывать BookReadException
            если после чтения полей в бибилиотеке нет места то выбрасывать LibrarySpaceException

        BookReadException extends RuntimeException

        LibrarySpaceException extends Exception
        - Book book
     */

    public static void main(String[] args)
    {
        //System.out.println("программа начала работу");

        //int[] arr = new int[10];

        /*try {
            arr[11] = 11;
            double d = 6 / arr[5] * arr[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error 1");
        } catch (ArithmeticException e) {
            System.out.println("error 2");
        }*/

        /*try {
            arr[11] = 11;
            double d = 6 / arr[5] * arr[6];
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("error " + e.getMessage());
        }*/

        /*try {
            arr[11] = 11;
            double d = 6 / arr[5] * arr[6];
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }*/

        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("программа продолжила работу");*/

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите что-то: ");
        String s = scanner.nextLine();

        int i = Integer.parseInt(s);
        System.out.println(i);
    }

    public static void sleep(int ms) throws InterruptedException
    {
        Thread.sleep(ms);
    }

    public static int test(int i) {
        if(i > 100) {
            throw new MyRuntimeException("test");
        }
        return i += 100;
    }
}
