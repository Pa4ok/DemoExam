package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.BookTableForm;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

/**
 * главный класс
 */
public class App
{
    public static boolean admin = false;

    /**
     * главный метод, точка входа в программу
     * @param args
     */
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*if(JOptionPane.showInputDialog(
                null,
                "Введите пароль админа (если знаете)",
                "Режим администратора",
                JOptionPane.QUESTION_MESSAGE
        ).equalsIgnoreCase("0000")) {
            admin = true;
        }*/

        changeAllFonts(new FontUIResource("Comic Sans MS", Font.TRUETYPE_FONT, 12));

        new BookTableForm();
    }

    /**
     * метод для получения соединения с бд
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }

    public static void changeAllFonts(Font font)
    {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, font);
        }
    }
}
