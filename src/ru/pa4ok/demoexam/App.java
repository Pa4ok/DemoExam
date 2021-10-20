package ru.pa4ok.demoexam;

import java.util.*;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
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

        - public List<Book> getSortedById()
        - public List<Book> getSortedByTitle()
        - public List<Book> getSortedByPages()
        - public List<Book> getAuthorBooks(String author)

     */


    public static void main(String[] args) {
        List<Test> list = new ArrayList<>(Arrays.asList(
                new Test("ccc", 1),
                new Test("aaa", 3),
                new Test("bbb", 2)
        ));

        //копия коллекции
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

        /*Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.title, o2.title);
            }
        });*/

        //то же самое что и сверху
        //Collections.sort(list, (o1, o2) -> Integer.compare(o1.value, o2.value));

        //снова то же самое
        //Collections.sort(list, Comparator.comparingInt(o -> o.value));

        System.out.println(list);
    }
}

class Test {
    public String title;
    public int value;

    public Test(String title, int value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return value == test.value && Objects.equals(title, test.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, value);
    }
}