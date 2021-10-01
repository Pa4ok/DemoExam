package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

public class App //
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

    public static void main(String[] args) {
        //System.out.println("mark1");

        /*try {
            int[] arr = new int[3];
            arr[4] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка поймана");
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[4] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка поймана 1");
        } catch (ArithmeticException e) {
            System.out.println("ошибка поймана 2");
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[4] = 5;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка поймана");
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[4] = 5;
        } catch (Exception e) {
            System.out.println("ошибка поймана");
        }*/

        /*try {
            test();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            test2(60);
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.i);
        }*/

        //System.out.println("mark2");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println(i * 100);
    }

    public static void test() throws FileNotFoundException {
        FileReader fr = new FileReader("my-file.txt");
    }

    public static void test1(int i) throws MyRuntimeException{
        if(i > 50) {
            throw new MyRuntimeException();
        }
    }

    public static void test2(int i) throws MyException {
        if(i > 50) {
            throw new MyException(433);
        }
    }

    public static void test3(int i) {
        try {
            FileReader fr = new FileReader("my-file.txt");
        } catch (Exception e) {
            throw new RuntimeException("123efwewf", e);
        }
    }
}
