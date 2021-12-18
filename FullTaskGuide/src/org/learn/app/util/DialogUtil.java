package org.learn.app.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtil
{
    public static void showInfo(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, " Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, " Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
