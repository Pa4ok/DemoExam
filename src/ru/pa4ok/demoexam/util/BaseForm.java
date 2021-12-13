package ru.pa4ok.demoexam.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame
{
    public static String APP_TITLE = "Школа языков Леарн";
    public static Image APP_IMAGE = null;

    static {
        try {
            APP_IMAGE = ImageIO.read(BaseForm.class.getClassLoader().getResource("school_logo.png"));
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showError(null, "Ошибка при загрузке иконки");
        }
    }

    public BaseForm(int width, int height)
    {
        setMinimumSize(new Dimension(width, height));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2
        );

        setTitle(APP_TITLE);
        if(APP_IMAGE != null) {
            setIconImage(APP_IMAGE);
        }
    }
}
