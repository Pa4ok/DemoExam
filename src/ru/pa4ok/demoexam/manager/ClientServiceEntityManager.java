package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.ClientServiceEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ClientServiceEntityManager
{
    public static List<ClientServiceEntity> selectAll() throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = """
                    SELECT * FROM ClientService
                    INNER JOIN Client ON ClientService.ClientID = Client.ID
                    INNER JOIN Service ON ClientService.ServiceID = Service.ID
                    """;
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ClientServiceEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new ClientServiceEntity(
                        resultSet.getInt("ClientService.ID"),
                        resultSet.getInt("ClientID"),
                        resultSet.getInt("Service.ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getTimestamp("StartTime")
                ));
            }

            return list;
        }
    }

    public static List<ClientServiceEntity> selectAllInRange() throws SQLException
    {
        List<ClientServiceEntity> list = selectAll();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(2019, Calendar.JUNE, 1, 0, 0, 0);
        Date start = calendar.getTime();

        calendar.set(2019, Calendar.SEPTEMBER, 1, 0, 0, 0);
        Date end = calendar.getTime();

        list.removeIf(e -> e.getStartDateTime().before(start) || e.getStartDateTime().after(end));
        Collections.sort(list, Comparator.comparing(ClientServiceEntity::getStartDateTime));

        return list;
    }
}
