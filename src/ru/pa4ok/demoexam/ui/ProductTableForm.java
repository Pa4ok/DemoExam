package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.ProductEntity;
import ru.pa4ok.demoexam.manager.ProductEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.List;

public class ProductTableForm extends BaseForm
{
    private JTable table;
    private JPanel mainPanel;
    private JButton addButton;
    private JComboBox costFilterBox;

    private CustomTableModel<ProductEntity> model;

    public ProductTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();
        initBoxes();
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

    private void initBoxes()
    {
        costFilterBox.addItem("Все");

        try {
            List<ProductEntity> list = ProductEntityManager.selectAll();
            double maxCost = 0;
            for(ProductEntity p : list) {
                if(p.getCost() > maxCost) {
                    maxCost = p.getCost();
                }
            }

            for(int i=0; i < maxCost/10000; i++) {
                costFilterBox.addItem("От " + 10000 * i + " до " + 10000 * (i+1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        costFilterBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
            }
        });
    }

    private void applyFilters()
    {
        try {
            List<ProductEntity> all = ProductEntityManager.selectAll();

            if(costFilterBox.getSelectedIndex() != 0) {
                double min = 10000 * (costFilterBox.getSelectedIndex() - 1);
                double max = 10000 * costFilterBox.getSelectedIndex();
                all.removeIf(product -> product.getCost() < min || product.getCost() > max);
            }

            model.setRows(all);
            model.fireTableDataChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new ProductCreateForm();
        });

        if(!Application.ADMIN_MODE) {
            addButton.setEnabled(false);
        }
    }
}
