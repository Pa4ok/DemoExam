package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ClientServiceEntity;
import ru.pa4ok.demoexam.manager.ClientServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ClientServiceTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton backButton;

    private CustomTableModel<ClientServiceEntity> model;

    public ClientServiceTableForm()
    {
        super(800, 400);
        setContentPane(mainPanel);

        initTable();
        initButtons();
        initUpdateTask();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    ClientServiceEntity.class,
                    new String[] { "ID", "ID клиента", "ID услуги", "Услуга", "Имя", "Фамилия", "Отчетство", "Email", "Телефон", "Время записи", "Прошло дней" },
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
            DialogUtil.showError(this, "Ошибка получения данных");
        }
    }

    private void initUpdateTask()
    {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    List<ClientServiceEntity> list = ClientServiceEntityManager.selectAllInRange();
                    SwingUtilities.invokeLater(() -> {
                        model.setRows(list);
                        model.fireTableDataChanged();
                    });

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 2000, 2000);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ServiceTableForm();
        });
    }

}
