package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MaterialTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel<MaterialEntity> model;

    public MaterialTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    private void initTable()
    {
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

        try {
            model = new CustomTableModel<>(
                    MaterialEntity.class,
                    new String[] { "ID", "Наименование", "Кол-во в упаковке", "Ед.изм.", "Кол-во на складе", "Мин. кол-во", "Описание", "Цена", "Путь до картинки", "Тип матерала"},
                    MaterialEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка загрузки данных: " + e.getMessage());
        }
    }
}
