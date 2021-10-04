package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        /*Container c = new Container("fewffwwefwe");
        String s = (String) c.value;
        System.out.println(s.toUpperCase());*/

        /*Container c = new Container(new Book("fwepojfowf"));
        Book book = (Book) c.value;
        System.out.println(book.title.toUpperCase());*/

        //Container<String> c = new Container<>("fejowefjwe");
        //Container<Book> c1 = new Container<>(new Book("werfwefewef"));

        /*List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(0, "aaaa");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.remove(0);
        System.out.println(list);
        test(list);
        System.out.println(list);*/

        List<String> list = new ArrayList<>(Arrays.asList(
                "1", "123","321","1231"," 231321", "3"
        ));

        /*for(int i=0; i<list.size(); i++) {
            //...
        }

        for(String s : list) {
            //...
        }*/

        System.out.println(list);

        /*for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        //list.removeIf(s -> s.length() > 1);

        System.out.println(list);
    }

    public static void test(List<String> list) {
        list.add("bbbb");
    }
}

class Container<T>
{
    public T value;

    public Container(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Container{" +
                "value=" + value +
                '}';
    }
}

class Book
{
    public String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}

