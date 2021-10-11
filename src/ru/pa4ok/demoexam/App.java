package ru.pa4ok.demoexam;

import java.util.*;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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
        /*List<Test> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list.add(new Test("value-a-" + i, "value-b-" + i,"value-c-" + i));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                Test t = new Test("value-a-" + j, "value-b-" + j,"value-c-" + j);
                if(!list.contains(t)) {
                    list.add(t);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");*/

       /* Set<Test> set = new HashSet<>();
        for(int i=0; i<1000; i++) {
            set.add(new Test("value-a-" + i, "value-b-" + i,"value-c-" + i));
        }

        long startMills = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            for(int j=0; j<1000; j++) {
                set.add(new Test("value-a-" + j, "value-b-" + j,"value-c-" + j));
            }
        }

        System.out.println((System.currentTimeMillis() - startMills) + "ms");*/

        /*Set<Test> set = new HashSet<>();
        set.add(new Test("1", "2", "3"));
        set.add(new Test("4", "5", "6"));
        set.add(new Test("0", "-1", "-2"));
        System.out.println(set);

        for(Test t : set) {
            //...
        }*/

       /* Test t1 = new Test("1", "2", "3");
        Test t2 = new Test("4", "5", "6");
        Test t3 = new Test("1", "2", "3");

        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        System.out.println(t3.hashCode());*/

        /*String s1 = "123321";
        String s2 = "123321";
        System.out.println(s1.equals(s2));*/

        Test t1 = new Test("1", "2", "3");
        Test t2 = new Test("1", "2", "3");
        System.out.println(t1.equals(t2));

    }
}

class Test
{
    public String a;
    public String b;
    public String c;

    public Test(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(a, test.a) && Objects.equals(b, test.b) && Objects.equals(c, test.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
