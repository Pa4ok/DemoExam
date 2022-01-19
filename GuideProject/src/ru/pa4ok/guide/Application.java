package ru.pa4ok.guide;

import ru.pa4ok.guide.ui.ClientTableForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * библиотека-драйвер для субд mysql: mysql:mysql-connector-java:8.0.27
 * библиотека lombok: org.projectlombok:lombok:1.18.22
 *
 * готовая удаленная база mysql (если лень подымать свою)
 * адрес: 116.202.236.174:3306
 * название/пользователь/пароль: DemoExam
 * веб интерфейс: https://phpmy.pa4ok.ru/
 * !!!создавайте таблицы со своими названиями, чтобы не было путаницы!!!
 */
public class Application
{
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception
    {
        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ClientTableForm();*/

        Files.createDirectories(Paths.get("./mine_out/"));
        Files.list(Paths.get("./mine/")).forEach(f -> {
            try {
                Image image = ImageIO.read(f.toFile()).getScaledInstance(96, 96, Image.SCALE_REPLICATE);

                BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D bGr = bi.createGraphics();
                bGr.drawImage(image, 0, 0, null);
                bGr.dispose();

                ImageIO.write(bi, "png", new File("./mine_out/" + f.getFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
