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
import java.util.List;

public class ProductTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton createButton;
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
                    new String[]{ "ID", "Наименование", "Тип", "Артикул", "Описание", "Путь до картинки", "Кол-во человек", "Номер станции", "Мин. цена", "Картинка" },
                    ProductEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
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
            for(int i=0; i<maxCost / 10000D; i++) {
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

    private  void applyFilters()
    {
        try {
            List<ProductEntity> list = ProductEntityManager.selectAll();

            if(costFilterBox.getSelectedIndex() != 0) {
                double min = (costFilterBox.getSelectedIndex()-1) * 10000;
                double max = costFilterBox.getSelectedIndex() * 10000;
                list.removeIf(p -> p.getCost() < min || p.getCost() > max);
            }

            model.setRows(list);
            model.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initButtons()
    {
        createButton.addActionListener(e -> {
            dispose();
            new ProductCreateForm();
        });

        if(!Application.ADMIN_MODE) {
            createButton.setEnabled(false);
        }
    }
}
