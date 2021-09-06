import java.util.Arrays;
import java.util.Random;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибок
 */

public class App
{
    public static void main(String[] args)
    {
        /*Book b = new Book();
        //System.out.println(b);
        System.out.println("MyBook: " + b.title + " " + b.pages);
        b.title = "[fkp2o3f2";
        b.pages = 123;
        System.out.println("MyBook: " + b.title + " " + b.pages);*/

        //Book b = new Book("fkgpr3e3", 123);
        //System.out.println("MyBook: " + b.title + " " + b.pages);
        //b.print();
        //System.out.println(b);

        /*
            class House
            - String address
            - int floorCount
            - int humanCount
            - public void addHuman() ++
            - public void removeHuman() --
            
            написать класс, с конструктором, переопределенным выводом (toString)
            на метод removeHuman необходимо повесить проверку, чтобы число humanCount не стало < 0
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
    }

    public String toString()
    {
        return "MyBook: " + this.title + " " + pages;
    }

    public void print()
    {
        System.out.println("MyBook: " + this.title + " " + pages);
    }
}

