package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        Product
        - int id
        - String title
        - double cost
        - int countInStock
     */

    public static void main(String[] args)
    {
        /*Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(0L);
        System.out.println(date1);

        Date date2 = new Date(1000000);
        System.out.println(date2);

        long daysMills = TimeUnit.DAYS.toMillis(64);
        Date date3 = new Date(daysMills);
        System.out.println(date3);
        */

        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date = new Date();
        //System.out.println(dateFormat.format(date));

        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        try {
            Date date = dateFormat.parse(dateString);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //System.out.println(System.currentTimeMillis());
        //System.out.println(new Date().getTime());

        /*Date date1 = new Date(1000);
        Date date2 = new Date(100000);
        System.out.println(date1.compareTo(date2));
        System.out.println(date1.before(date2));*/

        try {
            //BookEntityManager.add(new BookEntity("title", "pa4ok", 2000, new Date()));

            BookEntity b2 = BookEntityManager.selectById(2);
            b2.setWriteDateTime(new Date(1000));
            BookEntityManager.update(b2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
