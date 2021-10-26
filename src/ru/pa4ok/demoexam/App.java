package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
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

         создать таблицу в базе, сущность в программе и метод добавления сущностей в базу
     */

    public static void main(String[] args) throws SQLException {
        /*BookEntity book = new BookEntity("title-1", "author-1", 1411);

        System.out.println(book);

        try {
            BookEntityManager.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(book);*/

        //System.out.println(BookEntityManager.selectById(3));
        //System.out.println(BookEntityManager.selectAll());

        BookEntity b4 = BookEntityManager.selectById(4);
        System.out.println(b4);
        b4.setTitle("pghoregjk3333333");
        BookEntityManager.update(b4);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}