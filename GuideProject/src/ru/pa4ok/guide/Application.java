package ru.pa4ok.guide;

import ru.pa4ok.guide.entity.ClientEntity;
import ru.pa4ok.guide.manager.ClientEntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
    public static void main(String[] args)
    {
        /*ClientEntity client = new ClientEntity(
                1,
                "firstname",
                "efwwfe",
                "fewwfe",
                new Date(),
                new Date(),
                "efwwefwe",
                "wefwefwef",
                'm'
        );*/

        try {
            /*System.out.println(client);
            ClientEntityManager.insert(client);
            System.out.println(client);*/

            //System.out.println(ClientEntityManager.selectById(59));
            //System.out.println(ClientEntityManager.selectById(1090));

            /*List<ClientEntity> list = ClientEntityManager.selectAll();
            for(ClientEntity c : list) {
                System.out.println(c);
            }*/

            /*ClientEntity client = ClientEntityManager.selectById(59);
            System.out.println(client);
            client.setEmail("123321@mail.ru");
            ClientEntityManager.update(client);*/

            ClientEntityManager.delete(55);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306/DemoExam", "DemoExam", "DemoExam");
    }
}
