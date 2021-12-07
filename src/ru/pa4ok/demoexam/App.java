package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.ui.BookTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
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
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args)
    {
    /*
        берем первую базу, которую чинили (database-1)
        создаем сущность и менеджер под таблицу Client
        таблица уже в починенном виде есть на моем серверве

        делаем форму с таблицей через CustomTableModel
        по двойному клику должна открываться форма с редактированием/удалением
        также под таблицей должна быть кнопка для открытия формы добавления
     */

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new BookTableForm();

        //test();
    }

    private static void test()
    {
        try {
            List<BookEntity> list = BookEntityManager.selectAll();
            System.out.println(list);

            Collections.sort(list, new Comparator<BookEntity>() {
                @Override
                public int compare(BookEntity o1, BookEntity o2) {
                    /*
                        o1 < o2 | <0
                        o1 = o2 | 0
                        o1 > o2 | >0
                     */
                    return Integer.compare(o1.getPages(), o2.getPages());
                    //return o1.getAuthor().compareTo(o2.getAuthor());
                }
            });

            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}



