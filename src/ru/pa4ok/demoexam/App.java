package ru.pa4ok.demoexam;

import ru.pa4ok.test.Book;

/**
 * sout - принтлн
 * psvm - главный метод
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * cntl + space - подсказка по методам после точки
 * alt + enter - вывод контекстного меню по исправлению ошибки
 */
public class App
{
    /*
        все поля приватными + геттеры и сеттеры
        +переопределенный вывод (toString)

        Car
        - String type
        - int mileage
        - public void addMileage() //mileage++

        на сеттер для mileage необходимо повесить проверку
        чтобы новое значение не могло быть меньше старого
     */
    
    public static void main(String[] args)
    {
        Book book = new Book("ewfoiwefowe", "ewfewffewwef", 222);
        /*System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPages());
        book.setPages(-100);
        System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getPages());*/
        System.out.println(book);
    }
}
