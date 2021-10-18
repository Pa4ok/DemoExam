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
        - int id
        - String title
        - String author
        - ing pages

        Library
        - String address
        - Set<Book> books

        - public List<Book> getSortedById()
        - public List<Book> getSortedByTitle()
        - public List<Book> getSortedByPages()
        - public List<Book> getAuthorBooks(String author)
     */

    public static void main(String[] args)
    {
        List<Test> list = new ArrayList<>(Arrays.asList(
                new Test(2, "b"),
                new Test(3, "a"),
                new Test(1, "c")
        ));

        //копия списка
        //List<Test> copy = new ArrayList<>(list);

        System.out.println(list);

        /*Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                *//*
                    -1: o1 < o2
                     0: o1 = o2
                     1: o1 > o2
                 *//*
                if(o1.value > o2.value) {
                    return 1;
                }
                if(o1.value < o2.value) {
                    return -1;
                }
                return 0;
            }
        });*/

        /*Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });*/

        Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.title.compareTo(o2.title);
            }
        });

        //то же самое что и сверху
        //Collections.sort(list, (o1, o2) -> o1.title.compareTo(o2.title));

        //снова то же самое
        //Collections.sort(list, Comparator.comparing(o -> o.title));

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);
    }
}

class Test
{
    int value;
    String title;

    public Test(int value, String title) {
        this.value = value;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Test{" +
                "value=" + value +
                ", title='" + title + '\'' +
                '}';
    }
}