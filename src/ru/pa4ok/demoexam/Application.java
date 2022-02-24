package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.ui.ProductTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * главный класс
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

        ADMIN_MODE = "0000".equals(JOptionPane.showInputDialog("Введите пароль админа (если знаете)"));

        new ProductTableForm();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam4", "root", "1234");
    }
}
