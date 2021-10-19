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
        - public boolean hasBook(String title, String author, int pages)
        - public Book addBook(String title, String author, int pages)
        - public Book removeBook(String title, String author, int pages)

        методы addBook и removeBook принимают поля книги
        добавить книгу нужно только в том случае, если нет аналогичной
        если аналогичная книга есть, метод возврает null, если книга успешно добавлена - вернуть ее
        метод удаления книги возвращает объект удаленной из коллекции книги
        если такой книги в списке нет - возращаете null
     */

    public static void main(String[] args)
    {
        /*Container c1 = new Container("ewfpfojweoife");
        Container c2 = new Container(new Book(34));

        String s1 = (String) c1.value;
        Book b1 = (Book) c2.value;*/

        /*Container<String> c1 = new Container<>("ewfpfojweoife");
        Container<Book> c2 = new Container<>(new Book(34));

        String s1 = c1.value;
        Book b1 = c2.value;*/

        /*List<String> list = new ArrayList<>();

        list.add("rgojregreg");
        list.add("ewfeof");
        list.add("ewfeof");
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        //list.clear();
        list.set(1, "new123");

        System.out.println(list);*/

        List<String> list = new ArrayList<>(Arrays.asList(
                "1", "22", "3", "44", "55", "66", "7", "88", "9"
        ));

        /*for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        /*for(String s : list) {
            System.out.println(s);
        }*/

        System.out.println(list);

        /*for(int i=0; i<list.size(); i++) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        /*for(int i=0; i<list.size(); i++) {
            if(list.get(i).length() > 1) {
                list.remove(i);
                i--;
            }
        }*/

        /*for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i).length() > 1) {
                list.remove(i);
            }
        }*/

        list.removeIf(s -> s.length() > 1);

        System.out.println(list);
        t(list);
        System.out.println(list);

        /*Test t = new Test();
        t.list.add("123");*/
    }

    public static void t(List<String> list) {
        list.add("123");
    }
}

class Test
{
    //1
    //public List<String> list = new ArrayList<>();

    //2
    public List<String> list;

    public Test(List<String> list) {
        this.list = list;
    }
}

/*class Container<T>
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
}*/

class Book
{
    public int pages;

    public Book(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                '}';
    }
}
