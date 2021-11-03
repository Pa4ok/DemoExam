package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * shift + F10 - запуск последней конфигурации
 * alt + enter - контекстное меню по исправлению ошибки
 * ctrl + space - контекстное меню по доступыным полям и методам объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString...)
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
         Product
        - int id
        - String title
        - double cost
        - Date manufactureDate

        написать консольное приложение, которое предоставляет пользователю выбор
        1 - вывести все продукты
        2 - добавить продукт (запросит все поля)
        3 - удалить продукт (запросит id)
        4 - отредактировать продукт (запросить id, а после все поля)
        0 - выход из программы
     */

    public static void main(String[] args) throws SQLException
    {
        //long mills = System.currentTimeMillis();
        //System.out.println(mills);

        //Date date = new Date();
        //System.out.println(date);
        //System.out.println(date.getTime());

        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(format.format(new Date()));
        String s = "2021-11-03 17:14:42";

        try {
            Date date = format.parse(s);
            System.out.println(date);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*Date date1 = new Date();
        Date date2 = new Date(0L);
        Date date3 = new Date(TimeUnit.DAYS.toMillis(56));

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        System.out.println(date1.compareTo(date2));
        System.out.println(date1.before(date2));*/

        //BookEntityManager.insert(new BookEntity("title 123", "pa4ok", 20, new Date()));
        //BookEntityManager.insert(new BookEntity("title 321", "pa4ok", 20, new Date(0L)));

        /*List<BookEntity> list = BookEntityManager.selectAll();
        for(BookEntity b : list) {
            System.out.println(b);
        }*/

        /*BookEntity b2 = BookEntityManager.selectById(2);
        b2.setWriteDateTime(new Date(TimeUnit.DAYS.toMillis(10000)));
        BookEntityManager.update(b2);*/

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
