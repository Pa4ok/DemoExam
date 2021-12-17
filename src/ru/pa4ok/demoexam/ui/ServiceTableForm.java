package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ServiceEntity;
import ru.pa4ok.demoexam.manager.ServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
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

        try {
            model = new CustomTableModel<>(
                    ServiceEntity.class,
                    new String[]{ "ID", "Название", "Длительность", "Стоимость", "Скидка", "Описание", "Путь до картинки" },
                    ServiceEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }
}
