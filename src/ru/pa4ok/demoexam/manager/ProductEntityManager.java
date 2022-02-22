package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductEntityManager
{
    public static List<ProductEntity> selectAll() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM Product";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ProductEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new ProductEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("ProductType"),
                        resultSet.getString("ArticleNumber"),
                        resultSet.getString("Description"),
                        resultSet.getString("Image"),
                        resultSet.getInt("ProductionPersonCount"),
                        resultSet.getInt("ProductionWorkshopNumber"),
                        resultSet.getDouble("MinCostForAgent")
                ));
            }

            return list;
        }
    }

    public static void insert(ProductEntity product) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "INSERT INTO Product(Title, ProductType, ArticleNumber, Description, Image, ProductionPersonCount, ProductionWorkshopNumber, MinCostForAgent) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getType());
            ps.setString(3, product.getArticle());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getImage());
            ps.setInt(6, product.getPersonCount());
            ps.setInt(7, product.getWorkshopNumber());
            ps.setDouble(8, product.getMinCost());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                product.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("entity not added");
        }
    }
}
