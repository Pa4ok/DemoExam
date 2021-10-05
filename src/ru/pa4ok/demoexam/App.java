package ru.pa4ok.demoexam;

import java.util.*;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
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
        - Set<Book> books
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
        /*List<String> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();

        list1.add("123");
        list2.add(new Book("123"));

        System.out.println(list1.contains("123"));
        System.out.println(list2.contains(new Book("123")));

        Book b1 = new Book("123");
        Book b2 = new Book("123");
        System.out.println(b1.equals(b2));*/

        //long startMills = System.currentTimeMillis();

        /*List<Book> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Book("title-" + i));
        }

        System.out.println(list);
        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Book b = new Book("title-" + i);
                if(!list.contains(b)) {
                    list.add(b);
                }
            }
        }
        System.out.println(list);*/

        /*Set<Book> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Book("title-" + i));
        }

        System.out.println(set);
        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Book("title-" + i));
            }
        }
        System.out.println(set);*/

        //System.out.println((System.currentTimeMillis() - startMills) + "ms");

        Book b1 = new Book("123");
        Book b2 = new Book("123");

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }
}

class Book
{
    public String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
