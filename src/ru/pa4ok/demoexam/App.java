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
import java.util.Scanner;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню с полями и методами объекта
 * alt + insert - контекстное меню генерации кода (конструктор, toString, геттеры, сеттеры...)
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
         - char gender
         - Date birthday
         - String profession

         создать таблицу в базе, сущность в программе и все 5 методов взаимодействия в менеджере для нее
     */

    public static void main(String[] args) throws ParseException, SQLException {
        /*long mills = System.currentTimeMillis();

        try(Connection c = getConnection()) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        mills = System.currentTimeMillis() - mills;

        System.out.println(mills);*/

        /*Date date = new Date();
        System.out.println(date);

        System.out.println();

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        System.out.println(format1.format(date));

        System.out.println();

        String stringDate = "01.2022.11 18-33-22";
        SimpleDateFormat format2 = new SimpleDateFormat("dd.yyyy.MM HH-mm-ss");
        try {
            Date date1 = format2.parse(stringDate);
            System.out.println(date1);
            System.out.println(format1.format(date1));

            System.out.println();
            System.out.println(date.compareTo(date1));
            System.out.println(Long.compare(date.getTime(), date1.getTime()));

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*String stringDate = "01.2000.11 18-33-22";
        SimpleDateFormat format2 = new SimpleDateFormat("dd.yyyy.MM HH-mm-ss");
        Date date = format2.parse(stringDate);

        BookEntity book = new BookEntity("some title", "pa4ok", 200, date);
        BookEntityManager.insert(book);
        System.out.println(book);*/

        /*List<BookEntity> list = BookEntityManager.selectAll();
        for(BookEntity b : list) {
            System.out.println(b);
        }*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите дату в формате yyyy-MM-dd HH:mm:ss ");
        String s = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(s);
        System.out.println(date);
        */

        char gender = 'w';
        String s = "" + gender;
        String s1 = String.valueOf(gender);
        char gender1 = s.charAt(0);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}

