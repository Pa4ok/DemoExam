package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.ProductEntity;
import ru.pa4ok.demoexam.manager.ProductEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class ProductTableForm extends BaseForm
{
    private JTable table;
    private JPanel mainPanel;
    private JButton addButton;

    private CustomTableModel<ProductEntity> model;

    public ProductTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    ProductEntity.class,
                    new String[]{ "ID", "Наименование", "Тип", "Артикул", "Описание", "Путь до картинки", "Кол-во человек", "Номер станции", "Цена для агента" },
                    ProductEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new ProductEditForm();
        });

        if(!Application.ADMIN_MODE) {
            addButton.setEnabled(false);
        }
    }
}
