package ru.pa4ok.demoexam.util;

import ru.pa4ok.demoexam.App;

import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame
{
    public static final String APP_TITLE = "Application";

    public BaseForm(int width, int height)
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2
        );

        setTitle(APP_TITLE + (App.admin ? " [admin mode]" : ""));
    }
}
