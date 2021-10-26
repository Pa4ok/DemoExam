package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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

        написать консольное приложение, которое предоставляет пользователю выбор
        1 - вывести все продукты
        2 - добавить продукт (запросит все поля)
        3 - удалить продукт (запросит id)
        4 - отредактировать продукт (запросить id, а после все поля)
        0 - выход из программы
     */

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите что-то");
        String line = scanner.nextLine();

        int i = Integer.parseInt(line);
        double d = Double.parseDouble(line);

        /*BookEntity b = new BookEntity("title1", "author1", 100);

        System.out.println(b);

        try {
            BookEntityManager.add(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(b);*/

        /*try {
            //System.out.println(BookEntityManager.selectById(3));
            //System.out.println(BookEntityManager.selectAll());

            BookEntity b4 = BookEntityManager.selectById(4);
            System.out.println(b4);
            b4.setTitle("new title");
            b4.setAuthor("oeiwfohef");
            b4.setPages(111);
            BookEntityManager.update(b4);

            BookEntityManager.delete(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    //получения соединения с базой данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam", "root", "1234");
    }
}
