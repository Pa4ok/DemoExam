package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
         
         создать таблицу в базе, сущность в программе и менеджер со всеми 5 методами
     */

    public static void main(String[] args)
    {
        BookEntity book = new BookEntity("titewfouewf", "weofhoewif", 111);
        //System.out.println(book);

        try {
            BookEntityManager.insert(book);

            /*BookEntity b5 = BookEntityManager.selectById(5);
            b5.setTitle("title for 5");
            b5.setAuthor("Pa4ok");
            b5.setPages(1337);
            BookEntityManager.update(b5);*/

            /*List<BookEntity> list = BookEntityManager.selectAll();
            for(BookEntity b : list) {
                System.out.println(b);
            }*/

            //BookEntityManager.delete(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(book);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}
