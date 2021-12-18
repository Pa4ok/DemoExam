package org.learn.app.manager;

import org.learn.app.App;
import org.learn.app.entity.ClientServiceEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ClientServiceEntityManager
{
    public static List<ClientServiceEntity> selectAll() throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = """
                    SELECT * FROM ClientService
                    INNER JOIN Client ON Client.ID = ClientService.ClientID
                    INNER JOIN Service ON Service.ID = ClientService.ServiceID
                    """;
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ClientServiceEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new ClientServiceEntity(
                        resultSet.getInt("ID"),
                        resultSet.getInt("ClientID"),
                        resultSet.getInt("ServiceID"),
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
        Date startDate = calendar.getTime();

        calendar.set(2019, Calendar.SEPTEMBER, 1, 0, 0, 0);
        Date endDate = calendar.getTime();

        list.removeIf(e -> e.getStartDateTime().before(startDate) || e.getStartDateTime().after(endDate));

        Collections.sort(list, new Comparator<ClientServiceEntity>() {
            @Override
            public int compare(ClientServiceEntity o1, ClientServiceEntity o2) {
                return o1.getStartDateTime().compareTo(o2.getStartDateTime());
            }
        });

        return list;
    }
}
