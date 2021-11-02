package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestManger
{
    public static void test() throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "SELECT * FROM ClientService JOIN Client ON Client.ID = ClientID WHERE ClientService.ID=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, 12);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                System.out.println(resultSet.getInt("ClientService.ID"));
                System.out.println(resultSet.getInt("ClientID"));
                System.out.println(resultSet.getString("FirstName"));
                System.out.println(resultSet.getString("LastName"));
                System.out.println(resultSet.getString("Email"));
                System.out.println(resultSet.getInt("ServiceID"));
                System.out.println(resultSet.getTimestamp("StartTime"));
            } else {
                System.out.println("null");
            }
        }
    }
}
