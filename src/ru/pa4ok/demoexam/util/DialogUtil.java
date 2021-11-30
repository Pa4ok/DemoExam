package ru.pa4ok.demoexam.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtil
{
    public static void showError(Component parentComponent, String text)
    {
        JOptionPane.showMessageDialog(parentComponent, text, " Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    public static void showError(String text)
    {
        showError(null, text);
    }

    public static void showInfo(Component parentComponent, String text)
    {
        JOptionPane.showMessageDialog(parentComponent, text, " Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showInfo(String text)
    {
        showInfo(null, text);
    }
}
