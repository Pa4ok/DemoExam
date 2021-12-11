package ru.pa4ok.table.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame
{
    public static String APP_TITLE = "Расширенная версия CustomTableModel [НЕ РЕКОМЕНДУЕТСЯ ЕСЛИ ЕСТЬ ПРОБЛЕМЫ С ОБЫЧНОЙ]";
    public static Image APP_IMAGE = null;

    static {
        try {
            APP_IMAGE = ImageIO.read(BaseForm.class.getClassLoader().getResource("service_logo.png"));
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showError(null, "Иконка не найдена");
        }
    }

    public BaseForm(int width, int height)
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height));
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
