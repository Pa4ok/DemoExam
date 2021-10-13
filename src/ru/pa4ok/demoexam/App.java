package ru.pa4ok.demoexam;

import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Book> list = new ArrayList<>(Arrays.asList(
                new Book(2, "b", "2", 2),
                new Book(1, "c", "1", 1),
                new Book(3, "a", "3", 3)

        ));

        System.out.println(list);

        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //-1 o1 < o2
                //0 o1 == o2
                //1 o1 > o2

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

        //тоже самое что и сверху
        //Collections.sort(list, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);

        //копия коллекции, ЭЛЕМЕНТЫ 1 И ТЕ ЖЕ
        //List<Book> copy = new ArrayList<>(list);
    }
}
