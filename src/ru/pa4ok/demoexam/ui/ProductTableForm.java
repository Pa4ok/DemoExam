package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ProductEntity;
import ru.pa4ok.demoexam.manager.ProductEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class ProductTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel<ProductEntity> model;

    public ProductTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    ProductEntity.class,
                    new String[]{"ID", "Наименование", "Тип", "Артикул", "Описание", "Путь до картинки", "Количество человек", "Номер станции", "Цена для агента", "Картинка"},
                    ProductEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }
}
