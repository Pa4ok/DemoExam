package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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

        BookReadException extends Exception

        LibrarySpaceException extends Exception
        - Book book
     */


    public static void main(String[] args) {
        //System.out.println("mark1");

        /*try {
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена: " + e.getMessage());
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена 1: " + e.getMessage());
        }  catch (ArithmeticException e) {
            System.out.println("ошибка отловлена 2: " + e.getMessage());
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка отловлена: " + e.getMessage());
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 5;
        } catch (Exception e) {
            System.out.println("ошибка отловлена: " + e.getMessage());
        }*/

        /*try {
            FileReader fr = new FileReader("wreg;ojrwgoifew.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            test();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            test2(60);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
            test3(3);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //test4();

        //System.out.println("mark2");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("введите что-то: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println(i * 100);
    }

    public static void test() throws FileNotFoundException
    {
        FileReader fr = new FileReader("wreg;ojrwgoifew.txt");
    }

    public static void test2(int i) {
        if(i > 50) {
            throw new RuntimeException("123");
        }
    }

    public static void test3(int i) throws Exception
    {
        if(i > 50) {
            throw new Exception("123");
        }
    }

    public static void test4()
    {
        try {
            FileReader fr = new FileReader("wreg;ojrwgoifew.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("qdqwdqw", e);
        }
    }
}
