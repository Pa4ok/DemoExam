import java.util.Arrays;
import java.util.Random;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
        /*Book b = new Book();
        //System.out.println(b);
        System.out.println(b.title + " " + b.pages);
        b.title = "peojfp[owefe";
        b.pages = 314;
        System.out.println(b.title + " " + b.pages);*/

        Book b = new Book("2;fewpowfe", 23);
        //System.out.println(b.title + " " + b.pages);
        //b.print();
        System.out.println(b);

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

    public void print()
    {
        System.out.println("MyBook: " + this.title + " " + pages);
    }

    public String toString() {
        return "MyBook: " + this.title + " " + pages;
    }
}
