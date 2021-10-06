package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author)
        - public boolean hasBook(String title, String author)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        /*Library lib = new Library(
                "wpefowepofwe",
                new ArrayList<>(Arrays.asList(
                        new Book("t1", "a1", 10),
                        new Book("t2", "a2", 10),
                        new Book("t3", "a3", 10),
                        new Book("t4", "a4", 10)
                ))
        );
        System.out.println(lib);
        System.out.println(lib.hasBook("t3", "a3"));
        System.out.println(lib.hasBook("t5", "a5"));
        System.out.println(lib.addBook("t5", "a5", 10));
        System.out.println(lib.addBook("t5", "a5", 10));
        System.out.println(lib.hasBook("t5", "a5"));
        System.out.println(lib.removeBook("t1", "a1"));
        System.out.println(lib.removeBook("t1", "a1"));
        System.out.println(lib);*/

        /*List<String> list1 = new ArrayList<>(Arrays.asList(
                "1", "2", "3"
        ));

        List<Book> list2 = new ArrayList<>(Arrays.asList(
                new Book("t1", "a1", 10),
                new Book("t2", "a2", 10),
                new Book("t3", "a3", 10)
        ));


        System.out.println(list1);
        System.out.println(list2);

        list1.remove("2");
        list2.remove(new Book("t2", "a2", 10));

        System.out.println(list1);
        System.out.println(list2);*/

        /*Book b1 = new Book("t1", "a1", 10);
        Book b2 = new Book("t1", "a1", 10);

        System.out.println(b1.equals(b2));*/

        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book("t1", "a1", 10),
                new Book("t2", "a2", 10),
                new Book("t3", "a3", 10)
        ));

        System.out.println(list);
        System.out.println(list.contains(new Book("t3", "a3", 10)));
        System.out.println(list.contains(new Book("efwefwefwfe", "a3", 10)));
        System.out.println(list.remove(new Book("t3", "a3", 10)));
        System.out.println(list.remove(new Book("tëfwewfwefwewf3", "a3", 10)));
        System.out.println(list);
    }
}
