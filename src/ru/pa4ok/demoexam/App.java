package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.entity.BookEntityCopy;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * shift + F10 - запуск выбранной конфигурации (точка входа psvm)
 * ctrl + space - подсказка по методам после точки
 * alt + enter - контекстное меню по исправлению ошибки
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры, сеттеры)
 */

/**
 * библиотека-драйвер для субд mysql: mysql:mysql-connector-java:8.0.27
 * библиотека lombok (также нужен одноименный плагин): org.projectlombok:lombok:1.18.22
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
        - Date birthday
        - String profession

         создать таблицу в базе, сущность в программе и менеджер на все 5 базовых методов работы с бд
     */

    public static void main(String[] args)
    {
        /*long mills = System.currentTimeMillis();
        System.out.println(mills);

        Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(0);
        System.out.println(date1);*/

        /*Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));
        */

        /*String s = "07.28.20";
        SimpleDateFormat format = new SimpleDateFormat("MM.dd.yy");
        try {
            Date date = format.parse(s);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //System.out.println(System.currentTimeMillis());
        //System.out.println(new Date().getTime());

        /*Date date1 = new Date(0);
        Date date2 = new Date();

        System.out.println(date1.compareTo(date2));
        System.out.println(date1.before(date2));*/

        //Date date = new Date(TimeUnit.DAYS.toMillis(14));
        //System.out.println(date);

        /*try {
            //BookEntityManager.insert(new BookEntity("123", "312", 222, new Date(TimeUnit.DAYS.toMillis(10000))));

            System.out.println(BookEntityManager.selectAll());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        BookEntityCopy book = new BookEntityCopy("123", "312", 222, new Date(TimeUnit.DAYS.toMillis(10000)));
        System.out.println(book);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
