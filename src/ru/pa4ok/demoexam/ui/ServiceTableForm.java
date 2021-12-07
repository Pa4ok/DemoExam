package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ServiceEntity;
import ru.pa4ok.demoexam.manager.ServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ServiceTableForm extends BaseForm
{
    private JTable table;
    private JPanel mainPanel;
    private JButton addButton;

    private CustomTableModel<ServiceEntity> model;

    public ServiceTableForm()
    {
        super(1000, 600);
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
                    ServiceEntity.class,
                    new String[] { "ID", "Название", "Длительность", "Стоимость", "Скидка", "Путь до картинки", "Описания", "Картинка" },
                    ServiceEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    if(row != -1) {
                        dispose();
                        new ServiceEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new ServiceCreateForm();
        });
    }
}
