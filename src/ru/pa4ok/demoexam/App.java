package ru.pa4ok.demoexam;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
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
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена");
            e.printStackTrace();
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена 1");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("ошибка отловлена 2");
            e.printStackTrace();
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка отловлена");
            e.printStackTrace();
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (Exception e) {
            System.out.println("ошибка отловлена");
            e.printStackTrace();
        }*/

        /*try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*try {
            test(555);
        } catch (MyException e) {
            e.printStackTrace();
        }*/

        /*try {
            test2(555);
        } catch (MyRuntimeException e) {
            System.out.println("ошибка отловлена: " + e.value);
        }*/

        //test3();

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите что-то: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println(i * 100);

        System.out.println("mark2");
    }

    public static void sleep(int sec) throws InterruptedException
    {
        Thread.sleep(sec * 1000);
    }

    public static void test(int i) throws MyException {
        if(i > 50) {
            throw new MyException();
        }
    }

    public static void test2(int i) {
        if(i > 50) {
            throw new MyRuntimeException(i);
        }
    }

    public static void test3()
    {
        try {
            FileReader fr = new FileReader("ewrfwefewf.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("eofhwoef", e);
        }
    }
}
