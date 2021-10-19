package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Book> books
        - public boolean hasBook(Book book)
        - public Book addBook(Book book)
        - public Book removeBook(Book book)

        методы addBook и removeBook принимают поля книги
        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее
        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        /*Library lib = new Library(
                "we;lfjweopfgwef",
                new ArrayList<>(Arrays.asList(
                        new Book("t1", "a1", 10),
                        new Book("t2", "a2", 10),
                        new Book("t3", "a3", 10)
                        ))
        );

        System.out.println(lib);
        lib.addBook("12312e", "321423432", 44);
        System.out.println(lib);*/

        /*Book b1 = new Book("t1", "a1", 10);
        Book b2 = new Book("t1", "a1", 10);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
        */

        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("t1", "a1", 10),
                new Book("t2", "a2", 10),
                new Book("t3", "a3", 10)
        ));

        System.out.println(list);

        System.out.println(list.contains(new Book("t2", "a2", 10)));
        System.out.println(list.indexOf(new Book("t2", "a2", 10)));

        System.out.println(list.remove(new Book("t2", "a2", 10)));

        System.out.println(list.contains(new Book("t2", "a2", 10)));
        System.out.println(list.indexOf(new Book("t2", "a2", 10)));

        System.out.println(list);

    }
}


