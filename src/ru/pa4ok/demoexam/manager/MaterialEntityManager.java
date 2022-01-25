package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.MaterialEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialEntityManager
{
    public static void insert(MaterialEntity material) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "INSERT INTO Material(Title, MaterialType, Unit, CountInPack, CountInStock, MinCount, Cost, Description, Image) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getType());
            ps.setString(3, material.getUnit());
            ps.setInt(4, material.getCountInPack());
            ps.setInt(5, material.getCountInStock());
            ps.setInt(6, material.getMinCount());
            ps.setDouble(7, material.getCost());
            ps.setString(8, material.getDesc());
            ps.setString(9, material.getImage());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                material.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("entity not added");
        }
    }

    public static void update(MaterialEntity material) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "UPDATE Material SET Title=?, MaterialType=?, Unit=?, CountInPack=?, CountInStock=?, MinCount=?, Cost=?, Description=?, Image=? WHERE ID=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getType());
            ps.setString(3, material.getUnit());
            ps.setInt(4, material.getCountInPack());
            ps.setInt(5, material.getCountInStock());
            ps.setInt(6, material.getMinCount());
            ps.setDouble(7, material.getCost());
            ps.setString(8, material.getDesc());
            ps.setString(9, material.getImage());
            ps.setInt(10, material.getId());

            ps.executeUpdate();
        }
    }

    public static List<MaterialEntity> selectAll() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM Material";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<MaterialEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new MaterialEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("MaterialType"),
                        resultSet.getString("Unit"),
                        resultSet.getInt("CountInPack"),
                        resultSet.getInt("CountInStock"),
                        resultSet.getInt("MinCount"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Description"),
                        resultSet.getString("Image")
                ));
            }

            return list;
        }
    }

    public static void delete(MaterialEntity material) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "DELETE FROM Material WHERE ID=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, material.getId());
            ps.executeUpdate();
        }
    }
}
