package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.ProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
