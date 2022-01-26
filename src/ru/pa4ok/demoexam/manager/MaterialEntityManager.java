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
            String sql = "INSERT INTO Material(Title, MaterialType, Unit, Cost, CountInPack, CountInStock, MinCount, Description, Image) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getMaterialType());
            ps.setString(3, material.getUnit());
            ps.setDouble(4, material.getCost());
            ps.setInt(5, material.getPackCount());
            ps.setInt(6, material.getStockCount());
            ps.setInt(7, material.getMinCount());
            ps.setString(8, material.getDesc());
            ps.setString(9, material.getImagePath());

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
            String sql = "UPDATE Material SET Title=?, MaterialType=?, Unit=?, Cost=?, CountInPack=?, CountInStock=?, MinCount=?, Description=?, Image=? WHERE ID=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, material.getTitle());
            ps.setString(2, material.getMaterialType());
            ps.setString(3, material.getUnit());
            ps.setDouble(4, material.getCost());
            ps.setInt(5, material.getPackCount());
            ps.setInt(6, material.getStockCount());
            ps.setInt(7, material.getMinCount());
            ps.setString(8, material.getDesc());
            ps.setString(9, material.getImagePath());
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
                        resultSet.getDouble("Cost"),
                        resultSet.getInt("CountInPack"),
                        resultSet.getInt("CountInStock"),
                        resultSet.getInt("MinCount"),
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
