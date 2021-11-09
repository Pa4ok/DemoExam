package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
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
         создать сущность и менедежер со всеми методами для таблицы Product
         протестить все методы
     */

    public static void main(String[] args)
    {
        /*System.out.println(System.currentTimeMillis());
        System.out.println();

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));*/

        /*String s = "06.28.2000";
        SimpleDateFormat format = new SimpleDateFormat("MM.dd.yyyy");
        try {
            Date date = format.parse(s);
            System.out.println(date);
            System.out.println(date.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*Date date1 = new Date(0L);
        Date date2 = new Date(100000000L);
        Date date3 = new Date(TimeUnit.DAYS.toMillis(100));

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        System.out.println();

        System.out.println(date1.compareTo(date2));
        System.out.println(date1.before(date2));*/

        try {
            BookEntityManager.insert(new BookEntity("title", "wqjwoqid", 44, new Date()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}



