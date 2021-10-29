package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
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
         создать таблицу в базе, сущность в программе и все 5 методов взаимодействия 
     */

    public static void main(String[] args)
    {
        //BookEntity book = new BookEntity(229, "t-e0fpjew", "ayhew9gfew", 222);

        //System.out.println(book);

        try {
            //BookEntityManager.insert(book);

            /*BookEntity b3 = BookEntityManager.selectById(3);
            BookEntity b10 = BookEntityManager.selectById(10);
            System.out.println(b3);
            System.out.println(b10);*/

            /*List<BookEntity> list = BookEntityManager.selectAll();
            for(BookEntity book : list) {
                System.out.println(book);
            }*/

            /*BookEntity b2 = BookEntityManager.selectById(2);
            b2.setTitle("b2 title");
            b2.setAuthor("Pa4ok");
            b2.setPages(228);
            BookEntityManager.update(b2);*/

            BookEntityManager.delete(4);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(book);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}
