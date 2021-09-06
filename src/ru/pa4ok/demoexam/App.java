package ru.pa4ok.demoexam;

import ru.pa4ok.test.Book;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 */

public class App
{
    public static void main(String[] args)
    {
        Book b = new Book("reighreg", 123);
        //System.out.println(book);
        /*b.print();
        b.title = "1234234";
        b.pages = 123;*/
        b.print();
        System.out.println("test: " + b.getTitle() + " " + b.getPages());
    }

    /*
        все поля в классах приватные + геттеры и сеттеры
        +конструктор на все поля

        class House
        - String address
        - int floorCount
        - int humanCount
        - public void print()
        - public void addHuman() ++
        - public void removeHuman() -- //+ повесить проверку на то что итоговое значение >= 0

        создать объект House и поиграться с методами

     */
}

