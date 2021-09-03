package ru.pa4ok.demoexam;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * cntl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    public static void main(String[] args)
    {
        Book book = new Book("ewfoiwefowe", 222);
        /*System.out.println(book);
        System.out.println(book.title + " " + book.pagesCount);*/
        book.test();

        /*
            class Book +конструктор со всеми полями
            - String title
            - String author
            - int pages

            создать объект класса Book

            создать статичную функцию в главном классе
            которая будет принимать книгу и рандомно менять в ней количество страниц

            +вывод полей книги до и после
         */
    }

    //public static void test(Book book) {}
}

class Book
{
    String title;
    int pagesCount;

    public Book(String titleIn, int pagesCountIn)
    {
        title = titleIn;
        pagesCount = pagesCountIn;
    }

    public Book(String titleIn)
    {
        title = titleIn;
    }

    public void test()
    {
        System.out.println("my book: " + title + " " + pagesCount);
    }
}
