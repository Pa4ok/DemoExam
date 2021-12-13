package ru.pa4ok.demoexam.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BaseForm extends JFrame
{
    public static String APP_TITLE = "Application";
    public static Image APP_ICON = null;

    static {
        try {
            APP_ICON = ImageIO.read(BaseForm.class.getClassLoader().getResource("icon.png"));
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showError(null, "Иконка приложения не загружена");
        }
    }

    public BaseForm(int width, int height)
    {
        setTitle(APP_TITLE);
        if(APP_ICON != null) {
            setIconImage(APP_ICON);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2
        );
    }
}
