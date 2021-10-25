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
        Human
        - int id
        - String fio
        - int yearOfBirth
        - char gender
        - double rating

        создать ручками таблицу в базе
        создать в программе сущность и обработчик с методом добавления в базу
        ===================
        дописать получение по id / всех записей / по году рожденияZ
     */

    public static void main(String[] args)
    {
        /*BookEntity b = new BookEntity("title1", "author1", 100);

        System.out.println(b);

        try {
            BookEntityManager.add(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(b);*/

        try {
            //System.out.println(BookEntityManager.selectById(3));
            //System.out.println(BookEntityManager.selectAll());

            /*BookEntity b4 = BookEntityManager.selectById(4);
            System.out.println(b4);
            b4.setTitle("new title");
            b4.setAuthor("oeiwfohef");
            b4.setPages(111);
            BookEntityManager.update(b4);*/

            BookEntityManager.delete(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //получения соединения с базой данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}
