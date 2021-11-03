package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * alt + enter - контекстное меню по исправлению ошибки
 * shift + F10 - запуск последней конфигурации
 * alt + insert - контекстное меню по генерации кода (конструторы, toString, геттеры и сеттеры)
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

    public static void main(String[] args)
    {
        //long mills = System.currentTimeMillis();
        //System.out.println(mills + "ms");

        //Date date = new Date();
        //System.out.println(date);
        //System.out.println(date.getTime());

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date = new Date();
        //System.out.println(format.format(date));

        /*SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String s = "18.07.2000";
        try {
            Date date = format.parse(s);
            System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*Date date1 = new Date();
        Date date2 = new Date(0L);
        Date date3 = new Date(TimeUnit.DAYS.toMillis(10));

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

        System.out.println(date1.compareTo(date2));
        System.out.println(date1.before(date2));*/

        /*try {
            //BookEntityManager.insert(new BookEntity("title 123", "pa4ok", 228, new Date()));

            List<BookEntity> list = BookEntityManager.selectAll();
            for(BookEntity b : list) {
                System.out.println(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

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
