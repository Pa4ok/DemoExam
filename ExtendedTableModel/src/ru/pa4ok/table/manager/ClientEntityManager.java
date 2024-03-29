package ru.pa4ok.table.manager;

import ru.pa4ok.table.Application;
import ru.pa4ok.table.entity.ClientEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientEntityManager
{
    public static void insert(ClientEntity client) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "INSERT INTO Client(FirstName, LastName, Patronymic, Birthday, RegistrationDate, Email, Phone, GenderCode, PhotoPath) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getPatronymic());
            ps.setTimestamp(4, new Timestamp(client.getBirthday().getTime()));
            ps.setTimestamp(5, new Timestamp(client.getRegisterDate().getTime()));
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setString(8, client.getGender());
            ps.setString(9, client.getPhotoPath());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                client.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("entity not added");
        }
    }

    public static void update(ClientEntity client) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "UPDATE Client SET FirstName=?, LastName=?, Patronymic=?, Birthday=?, RegistrationDate=?, Email=?, Phone=?, GenderCode=?, PhotoPath=? WHERE ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getPatronymic());
            ps.setTimestamp(4, new Timestamp(client.getBirthday().getTime()));
            ps.setTimestamp(5, new Timestamp(client.getRegisterDate().getTime()));
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setString(8, client.getGender());
            ps.setString(9, client.getPhotoPath());
            ps.setInt(10, client.getId());

            ps.executeUpdate();
        }
    }

    public static List<ClientEntity> selectAll() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM Client";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ClientEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new ClientEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getTimestamp("Birthday"),
                        resultSet.getTimestamp("RegistrationDate"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString("GenderCode").equals("м") ? "мужской" : "женский",
                        resultSet.getString("PhotoPath")
                ));
            }

            return list;
        }
    }

    public static void delete(int id) throws SQLException
    {
        try (Connection c = Application.getConnection())
        {
            String sql = "DELETE FROM Client WHERE ID=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static void delete(ClientEntity client) throws SQLException
    {
        delete(client.getId());
    }
}