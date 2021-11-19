package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.CreateBookForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по достпуным методам и полям объекта (после точки)
 * alt + insert - контекстное меню генерации кода (конструкторы, toString, геттеры и сеттеры)
 */

/**
 * библиотека-драйвер для субд mysql: mysql:mysql-connector-java:8.0.27
 * библиотека lombok: org.projectlombok:lombok:1.18.22
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
        берем первую базу, которую чинили (database-1)
        и делаем форму для добавления сущностей в таблицу Client
        починить таблицу -> сделать класс сущность и менеджер -> сделать форму
     */

    public static void main(String[] args) throws ParseException
    {
        /*long mills = System.currentTimeMillis();
        System.out.println(mills);

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());*/

        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
        String s = "2000-11-01 15:33:21";
        Date date = format.parse(s);
        System.out.println(date);*/

        /*Date date1 = new Date();
        Date date2 = new Date(0);
        Date date3 = new Date(TimeUnit.DAYS.toMillis(100));

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        System.out.println();

        System.out.println(date1.compareTo(date2));
        System.out.println(date2.before(date3));*/

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new CreateBookForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
