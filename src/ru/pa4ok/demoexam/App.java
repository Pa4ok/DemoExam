package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
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

        создаете библиотеку и в цикле while(true) читаете книги
        если вылетает BookReadException продолжаете читать
        если вылетает LibrarySpaceException завершаете цикл
     */
    public static void main(String[] args) {
        //System.out.println("mark1");

        /*try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ошибка отловлена 1 " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ошибка отловлена 2 " + e.getMessage());
        }*/

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        } */

        /*try {
            double d = 5 / 0;
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (Exception e) {
            System.out.println("ошибка отловлена " + e.getMessage());
        }*/

        /*try {
            FileReader fr = new FileReader("regergreuhgre.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            test();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            test1(60);
        } catch (MyException e) {
            System.out.println("ошибка: " + e.value);
        }*/

        //test2();
        //System.out.println("mark2");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("введите что-то: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println(i * 100);
    }

    public static void test() throws FileNotFoundException {
        FileReader fr = new FileReader("regergreuhgre.txt");
    }

    public static void test1(int i) throws MyException {
        if (i > 50) {
            throw new MyException(i);
        }
    }

    public static void test2() {
        //...
        try {
            FileReader fr = new FileReader("23423432432");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //...
    }
}
