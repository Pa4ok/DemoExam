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
import java.util.Random;
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
         UserEntity
         - int id (автоинкремент)
         - String fio
         - char gender
         - Date birthday
         - String profession

        написать консольное приложение, которое предоставляет пользователю выбор
        1 - вывести всех пользователей
        2 - добавить пользователя (запросит все поля)
        3 - удалить пользователя (запросит id)
        4 - отредактировать пользователя (запросить id, а после все поля)
        0 - выход из программы
     */

    public static void main(String[] args) throws SQLException
    {
        /*Date date = new Date();
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));

        Date date1 = new Date(0L);
        System.out.println(date1);

        String dateString = "28.12.20 23:22:36";
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        try {
            Date date2 = format1.parse(dateString);
            System.out.println(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());*/

        //BookEntityManager.insert(new BookEntity("tielwepihfef", "pa4ok", 100, new Date()));

        /*List<BookEntity> list = BookEntityManager.selectAll();
        for(BookEntity book : list) {
            System.out.println(book);
        }*/

        /*BookEntity b1 = BookEntityManager.selectById(1);
        b1.setWriteDateTime(new Date(100000));
        BookEntityManager.update(b1);*/

        /*long tenDayMills = TimeUnit.DAYS.toMillis(10);
        System.out.println(tenDayMills);

        BookEntity b1 = BookEntityManager.selectById(1);
        b1.setWriteDateTime(new Date(tenDayMills));
        BookEntityManager.update(b1);*/

        /*char gender = 'w';
        String s1 = "" + gender;
        String s2 = String.valueOf(gender);
        char genderBack = s2.charAt(0);*/

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите что-то: ");
        String s = scanner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println(i);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}