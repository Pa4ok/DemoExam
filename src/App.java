/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 */

public class App
{
    public static void main(String[] args)
    {
        Book b = new Book("some title", 123);
        //System.out.println(b);
        //System.out.println(b.title + " " + b.pages);
        /*b.title = "some title";
        b.pages = 123;
        System.out.println(b.title + " " + b.pages);*/
        //b.test();
        b.print();

        /*
            class House
            - String address
            - int floorCount
            - int humanCount
            - public void print()

            class App/Main/...
            - главная функция main
            - public static void addHuman(House house)
            - public static void removeHuman(House house)
            //на фукнцию removeHuman необходимо повесить проверку
            //на то чтобы количество людей в доме не стало отрицательным

            создать объект House
            и потестить функции
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
        this.title = title;
        if(this.title.startsWith("123")) {
            this.title = this.title.replace("123", "321");
        }

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
        System.out.println("MyBook: " + title + " " + this.pages);
    }

    public void test() {
        System.out.println("test");
    }
}