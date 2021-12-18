package org.learn.app;

import org.learn.app.ui.ServiceTableForm;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * главный класс
 */
public class App
{
    public static boolean ADMIN_MODE = false;

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

        changeAllFonts(new FontUIResource("Comic Sans MS", Font.TRUETYPE_FONT, 12));

        ADMIN_MODE = "0000".equalsIgnoreCase(JOptionPane.showInputDialog(null, "Введите пароль администратора, если знаете", "Режим администратора", JOptionPane.QUESTION_MESSAGE));

        new ServiceTableForm();
    }

    /**
     * метод для получения соединения с базой данных
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "1234");
    }

    /**
     * метод смены всех шриафтов
     * @param font
     */
    public static void changeAllFonts(Font font)
    {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, font);
        }
    }
}
