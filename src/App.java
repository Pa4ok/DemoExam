import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        /*Book b = new Book();
        System.out.println(b);
        System.out.println(b.title + " " + b.pages);
        b.title = "324o3j34ogj";
        b.pages = 123;
        System.out.println(b.title + " " + b.pages);*/

        Book b = new Book("324234432reg'reihg", 123);
        //System.out.println(b.title + " " + b.pages);
        //b.print();
        System.out.println(b);

        /*
            констуктор + переопределнный вывод (toString)

            class Car
            - String type
            - int mileage
            - public void addMileage() ++
         */
    }
}

class Book
{
    String title;
    int pages;

    //constructor(String,int)
    public Book(String title, int pagesIn)
    {
        if(title.startsWith("123")) {
            title = title.replace("123", "321");
        }
        this.title = title;
        pages = pagesIn;
    }

    //constructor(String)
    /*public Book(String title)
    {
        this.title = title;
    }*/

    public Book(String title)
    {
        this(title, 0);
        //...
    }

    public void print() {
        System.out.println("MyBook: " + this.title + " " + pages);
    }

    public String toString() {
        return "MyBook: " + this.title + " " + pages;
    }
}
