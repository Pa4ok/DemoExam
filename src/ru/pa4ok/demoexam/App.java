package ru.pa4ok.demoexam;

import java.util.*;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
 */

public class App {

    /*
        Book
        - int id
        - String title
        - String author
        - ing pages

        Library
        - String address
        - Set<Book> books
        - Map<Integer, Book> bookIdCache //ключ - id книги, объект - сама книга

        - public List<Book> getSortedById()
        - public List<Book> getSortedByTitle()
        - public List<Book> getSortedByPages()
        - public List<Book> getAuthorBooks()

     */

    public static void main(String[] args)
    {
        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book(3, "c", "3", 3),
                new Book(1, "a", "1", 1),
                new Book(2, "b", "2", 2)
        ));

        /*List<Book> newList = new ArrayList<>(list);
        newList.removeIf(book -> book.getId() < 3);*/

        //list.removeIf(book -> book.getPages() < 50);

        System.out.println(list);

        /*Collections.sort(list, (o1, o2) -> {
            if(o1.getId() > o2.getId()) {
                return 1;
            }
            if(o1.getId() < o2.getId()) {
                return -1;
            }
            return 0;
        });*/

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getId() > o2.getId()) {
                    return 1;
                }
                if(o1.getId() < o2.getId()) {
                    return -1;
                }
                return 0;
            }
        });*/

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });*/

        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);
    }
}
