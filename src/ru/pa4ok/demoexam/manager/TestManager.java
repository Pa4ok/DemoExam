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
            String sql = "SELECT * FROM clientservice JOIN client ON client.ID = clientservice.ClientID WHERE clientservice.ID=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, 49);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                System.out.println("ID        : " + resultSet.getInt("clientservice.ID"));
                System.out.println("ClientID  : " + resultSet.getInt("ClientID"));
                System.out.println("ServiceID : " + resultSet.getInt("ServiceID"));
                System.out.println("StartTime : " + resultSet.getTimestamp("StartTime"));
                System.out.println("Comment   : " + resultSet.getString("Comment"));
                System.out.println("FirstName : " + resultSet.getString("FirstName"));
                System.out.println("Email     : " + resultSet.getString("Email"));
            } else {
                System.out.println("null");
            }
        }
    }
}
