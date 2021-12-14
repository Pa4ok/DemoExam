package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ServiceEntity;
import ru.pa4ok.demoexam.manager.ServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.SQLException;

public class ServiceTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel<ServiceEntity> model;

    public ServiceTableForm()
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
                    ServiceEntity.class,
                    new String[] { "ID", "Название", "Длительность", "Стоимость", "Скидка", "Описание", "Путь до картинки", "Картинка" },
                    ServiceEntityManager.selectAll()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
