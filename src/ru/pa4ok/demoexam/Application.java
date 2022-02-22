package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.ProductTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * alt + enter - контекстное меню исправления ошибки
 * shift + F10 - запуск последней конфигурации
 * ctrl + space - контекстное меню с списком функций и полей объекта (после точки)
 * alt + insert - контекстное меню по генерации кода (конструкторы, геттеры, сеттеры, toString)
 */

/**
 * библиотека-драйвер для субд mysql        mysql:mysql-connector-java:8.0.27
 * библиотека lombok                        org.projectlombok:lombok:1.18.22
 * библиотека для тестирования              org.junit.jupiter:junit-jupiter:5.4.2
 *
 * готовая удаленная база mysql (если лень подымать свою):
 * адрес: 116.202.236.174:3306
 * название/пользователь/пароль: DemoExam
 * веб интерфейс: https://phpmy.pa4ok.ru/
 * !!!создавайте таблицы со своими названиями, чтобы не было путаницы!!!
 */

public class Application
{
    public static boolean ADMIN_MODE;

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ADMIN_MODE = "0000".equals(JOptionPane.showInputDialog(null, "Введите пароль админа (если знаете)"));

        new ProductTableForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam1", "root", "1234");
    }
}



