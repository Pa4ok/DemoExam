package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ClientServiceEntity;
import ru.pa4ok.demoexam.manager.ClientServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.SQLException;

public class ClientServiceTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton backButton;

    private CustomTableModel<ClientServiceEntity> model;

    public ClientServiceTableForm()
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

        try {
            model = new CustomTableModel<>(
                    ClientServiceEntity.class,
                    new String[]{ "ID", "ID клиента", "ID услуги", "Название услуги", "Имя", "Фамилия", "Отчество", "Email", "Телефон", "Дата записи" },
                    ClientServiceEntityManager.selectAllInRange()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("ID клиента");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

            column = table.getColumn("ID услуги");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ServiceTableForm();
        });
    }
}
