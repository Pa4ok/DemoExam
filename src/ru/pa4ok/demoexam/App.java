package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */
public class App {
      /*
        Book
        - String author
        - String title
        - ing pages

        Library
        - String address
        - List<Book> books
        - public boolean hasBook(String title, String author, int pages)
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги

        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее

        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */


    public static void main(String[] args) {
        Library lib = new Library(
                "wpeofjpweofjew",
                new ArrayList<>(Arrays.asList(
                        new Book("title-1", "author-1", 10),
                        new Book("title-2", "author-2", 10),
                        new Book("title-3", "author-3", 10)
                )));

        System.out.println(lib);
        System.out.println();
        System.out.println(lib.hasBook("title-3", "author-3", 10));
        System.out.println(lib.hasBook("title-4", "author-3", 10));
        System.out.println();
        System.out.println(lib.addBook("title-4", "author-3", 10));
        System.out.println(lib.addBook("title-4", "author-3", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib.removeBook("title-1", "author-1", 10));
        System.out.println(lib);
    }
}
