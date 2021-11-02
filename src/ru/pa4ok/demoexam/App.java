package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
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

         создать таблицу в базе, сущность в программе и менеджер к сущности со всеми 5 методами взаимодейсвия
     */


    public static void main(String[] args)
    {
        BookEntity book = new BookEntity("title-abc", "pa4ok", 220);

        try {

            /*System.out.println(book);
            BookEntityManager.insert(book);
            System.out.println(book);*/

            //System.out.println(BookEntityManager.selectById(7));
            //System.out.println(BookEntityManager.selectById(700));

            /*List<BookEntity> list = BookEntityManager.selectAll();
            for(BookEntity b : list) {
                System.out.println(b);
            }*/

            BookEntity b7 = BookEntityManager.selectById(7);
            System.out.println(b7);
            b7.setTitle("new title");
            b7.setAuthor("qwerty");
            b7.setPages(228);
            System.out.println(b7);
            BookEntityManager.update(b7);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
                                             // протокол     адрес           порт название базы   пользователь         пароль
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");

    }
}



