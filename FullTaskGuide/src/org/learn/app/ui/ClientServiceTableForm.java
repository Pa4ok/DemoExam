package org.learn.app.ui;

import org.learn.app.entity.ClientServiceEntity;
import org.learn.app.manager.ClientServiceEntityManager;
import org.learn.app.util.BaseForm;
import org.learn.app.util.CustomTableModel;
import org.learn.app.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * форма с ближайшими записями
 */
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
        initUpdate();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    ClientServiceEntity.class,
                    new String[]{ "ID", "ID клиента", "ID услуги", "Название услуги", "Имя", "Фамилия", "Отчество", "Email", "Телефон", "Дата и время начала", "Прошло дней" },
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
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ServiceTableForm();
        });
    }

    private void initUpdate()
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

        timer.scheduleAtFixedRate(task, 3000, 3000);
    }
}
