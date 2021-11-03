package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestManager
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
                System.out.println("ClientService.ID  :  " + resultSet.getInt("ClientService.ID"));
                System.out.println("ClientID          :  " + resultSet.getInt("ClientID"));
                System.out.println("FirstName         :  " + resultSet.getString("FirstName"));
                System.out.println("Email             :  " + resultSet.getString("Email"));
                System.out.println("ServiceID         :  " + resultSet.getInt("ServiceID"));
                System.out.println("StartTime         :  " + resultSet.getTimestamp("StartTime"));

            } else {
                System.out.println("null");
            }
        }
    }
}
