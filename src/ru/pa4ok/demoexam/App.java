package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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

         создать таблицу в базе, сущность в программе и менеджер к сущности со всеми 5ю методами взимодействия
     */

    public static void main(String[] args) throws SQLException {
        /*BookEntity book = new BookEntity("title-1", "author-1", 10);

        System.out.println(book);
        try {
            BookEntityManager.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(book);*/

        /*System.out.println(BookEntityManager.selectById(2));
        System.out.println(BookEntityManager.selectById(4));
        System.out.println(BookEntityManager.selectById(10));*/

        /*List<BookEntity> list = BookEntityManager.selectAll();
        for(BookEntity book : list) {
            System.out.println(book);
        }*/

        BookEntity b1 = BookEntityManager.selectById(1);
        System.out.println(b1);
        b1.setTitle("qwerty");
        b1.setAuthor("12345");
        b1.setPages(227);
        System.out.println(b1);
        BookEntityManager.update(b1);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
