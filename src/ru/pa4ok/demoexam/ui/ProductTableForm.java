package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.entity.ProductEntity;
import ru.pa4ok.demoexam.manager.ProductEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton helpButton;
    private JButton dealButton;
    private JComboBox costFilerBox;

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
                    new String[]{"ID", "Наименование", "Тип", "Артикул", "Описание", "Путь до картинки", "Количество человек", "Номер станции", "Цена для агента", "Картинка"},
                    ProductEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }

    private void initBoxes()
    {
        costFilerBox.addItem("Все");

        try {
            List<ProductEntity> products = ProductEntityManager.selectAll();
            double maxCost = 0;
            for(ProductEntity p : products) {
                if(p.getMinCost() > maxCost) {
                    maxCost = p.getMinCost();
                }
            }

            for(int i=0; i<maxCost / 10000; i++) {
                costFilerBox.addItem("От " + 10000 * i + " до " + 10000 * (i+1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        costFilerBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
            }
        });
    }

    private void applyFilters()
    {
        try {
            List<ProductEntity> all = ProductEntityManager.selectAll();

            if(costFilerBox.getSelectedIndex() != 0) {
                double min = 10000 * (costFilerBox.getSelectedIndex() - 1);
                double max = 10000 * costFilerBox.getSelectedIndex();
                all.removeIf(p -> p.getMinCost() < min || p.getMinCost() > max);
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

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование - двойной клик\nУдаление - внутри редактирования");
        });

        dealButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связаться с разработчиком можно по адресу user228@itmo.ru");
        });
    }
}
