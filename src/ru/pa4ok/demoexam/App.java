package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
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

         создать таблицу в базе, сущность в программе и менеджер на все 5 базовых методов работы с бд
     */

    public static void main(String[] args)
    {
        BookEntity book = new BookEntity("title", "pa4ok", 222);

        try {
            /*System.out.println(book);
            BookEntityManager.insert(book);
            System.out.println(book);*/

            //System.out.println(BookEntityManager.selectById(2));
            /*List<BookEntity> list = BookEntityManager.selectAll();
            for(BookEntity b : list) {
                System.out.println(b);
            }*/

            /*BookEntity b1 = BookEntityManager.selectById(1);
            b1.setTitle("new title");
            b1.setAuthor("new Author");
            b1.setPages(213);
            BookEntityManager.update(b1);*/

            BookEntityManager.delete(3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
