package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
 */

/**
 * библиотека-драйвер для субд mysql: mysql:mysql-connector-java:8.0.27
 *
 * готовая удаленная база mysql (если лень подымать свою):
 * адрес: 116.202.236.174:3306
 * название/пользователь/пароль: DemoExam
 * веб интерфейс: https://phpmy.pa4ok.ru/
 * !!!создавайте таблицы со своими названиями, чтобы не было путаницы!!!
 */

public class App
{
    /*
         UserEntity
         - int id (автоинкремент)
         - String fio
         - int yearOfBirth
         - String profession

         создать таблицу в базе, сущность в программе и все 5 методов взаимодействия в менеджере для нее
     */

    public static void main(String[] args)
    {
        /*BookEntity book = new BookEntity("title-1", "author-1", 10);

        System.out.println(book);
        try {
            BookEntityManager.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(book);*/

        try {
            //System.out.println(BookEntityManager.selectById(10));
            //System.out.println(BookEntityManager.selectAll());

            BookEntity b2 = BookEntityManager.selectById(2);
            System.out.println(b2);
            b2.setTitle("new title");
            b2.setAuthor("new author");
            b2.setPages(2124);
            BookEntityManager.update(b2);
            System.out.println(BookEntityManager.selectById(2));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}

