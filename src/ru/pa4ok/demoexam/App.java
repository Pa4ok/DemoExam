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
        /*MyContainer<String> container1 = new MyContainer<>(
                new String[]{
                        "1", "2", "3", "4", "5"
                }
        );

        MyContainer<Book> container2 = new MyContainer<>(
                new Book[]{
                        new Book("ewfewffew", "werfewrfew", 10),
                        new Book("ewfewffew", "werfewrfew", 10),
                        new Book("ewfewffew", "werfewrfew", 10),
                        new Book("ewfewffew", "werfewrfew", 10)
                }
        );*/

        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);
        list.set(3, "123");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains("2"));
        System.out.println(list.contains("4"));
        System.out.println(list.remove(2));
        System.out.println(list.remove("1"));
        System.out.println(list);*/

        /*List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        System.out.println(list);
        list.add("123");
        System.out.println(list);
        test(list);
        System.out.println(list);

        for(String s : list) {
            System.out.printf(s + " | ");
        }
        System.out.println();

        for(int i=0; i<list.size(); i++) {
            System.out.printf(list.get(i) + " | ");
        }
        System.out.println();*/

        //List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        //System.out.println(list);

        //плохо
        /*for(int i=0; i<list.size(); i++) {
            if(i % 2 == 1) {
                list.remove(i);
            }
        }*/

        //еще хуже
        /*for(String s : list) {
            if(Integer.parseInt(s) % 2 == 0) {
                list.remove(s);
            }
        }*/

        //если уж совсем нужен индекс, можно запустить с конца
        /*for(int i=list.size()-1; i>=0; i--) {
            if(i % 2 == 1) {
                list.remove(i);
            }
        }*/

        //удаление с условие всех подходящих элементов
        //list.removeIf(s -> Integer.parseInt(s) % 2 == 0);

        //System.out.println(list);

        Test t = new Test();
        System.out.println(t);
        t.getList().add("123");
        System.out.println(t);
    }

    public static void test(List<String> list)
    {
        list.set(0, "321");
    }
}

class MyContainer<T>
{
    private T[] arr;

    public MyContainer(T[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "MyContainer{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }
}

class Test
{
    private List<String> list = new ArrayList<>();

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "list=" + list +
                '}';
    }

    public List<String> getList() {
        return list;
    }
}

class Test1
{
    private List<String> list;

    public Test1(List<String> list) {
        this.list = list;
    }

    public Test1() {
        this(new ArrayList<>());
    }
}
