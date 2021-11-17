package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.CreateBookForm;
import ru.pa4ok.demoexam.ui.MainForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        берем первую базу, которую чинили (database-1)
        и делаем форму для добавления сущностей в таблицу Client
        починить таблицу -> сделать класс сущность и менеджер -> сделать форму
     */

    public static void main(String[] args) throws SQLException
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new MainForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
