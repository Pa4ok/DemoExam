/**
 * shift + F10 - запуск последней конфигурации
 */

public class App
{
    public static void main(String[] args)
    {
       /* Book book = new Book();
        System.out.println(book);*/
        /*System.out.println(book.title);
        System.out.println(book.pages);*/

        /*book.print();
        book.title = "wef[oewf";
        book.pages = 123;
        book.print();*/

        Book book = new Book("fewfew4", 1222);
        book.print();

        /*
            class House +конструктор со всеми полями
            - String address
            - ing floorCount
            - int humanCount
            - public void print()

            Main/App/главный класс
            создать в main методе объект House

            создать в главном классе 2 функции: addHuman(House house) и removeHuman(House house)
            увеличивать или уменьшать количество людей в объекте house из аргументов на 1
         */
    }
}

class Book
{
    String title;
    int pages;

    public Book(String title, int pagesIn)
    {
        this.title = title;
        pages = pagesIn;
    }

    public Book(String titleIn)
    {
        title = titleIn;
        pages = 100;
    }

    public void print()
    {
        System.out.println("MyBook: " + title + " " + pages);
    }
}