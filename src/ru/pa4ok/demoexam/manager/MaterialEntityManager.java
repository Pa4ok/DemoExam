package ru.pa4ok.demoexam.manager;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.MaterialEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  `CountInPack` INT NOT NULL,
  `Unit` VARCHAR(10) CHARACTER SET 'utf8mb4' NOT NULL,
  `CountInStock` DOUBLE NULL,
  `MinCount` DOUBLE NOT NULL,
  `Description` LONGTEXT CHARACTER SET 'utf8mb4' NULL,
  `Cost` DECIMAL(10,2) NOT NULL,
  `Image` VARCHAR(100) CHARACTER SET 'utf8mb4' NULL,
  `MaterialType` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL,
  PRIMARY KEY (`ID`)
 */
public class MaterialEntityManager
{
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
                        resultSet.getInt("CountInPack"),
                        resultSet.getString("Unit"),
                        resultSet.getDouble("CountInStock"),
                        resultSet.getDouble("MinCount"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Image"),
                        resultSet.getString("MaterialType")
                ));
            }

            return list;
        }
    }
}
