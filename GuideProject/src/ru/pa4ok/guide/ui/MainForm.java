package ru.pa4ok.guide.ui;

import ru.pa4ok.guide.entity.ClientEntity;
import ru.pa4ok.guide.manager.ClientEntityManager;
import ru.pa4ok.guide.util.BaseForm;
import ru.pa4ok.guide.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MainForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton listButton;
    private JButton addButton;
    private JButton editButton;

    public MainForm()
    {
        super(600, 400);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        listButton.addActionListener(e -> {
            dispose();
            new ClientTextListForm();
        });

        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });

        editButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this, "Введите id", "Ввод", JOptionPane.QUESTION_MESSAGE);
            if(s == null) {
                return;
            }

            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception ex) {
                DialogUtil.showError(this, "ID не введен или введен некоректно");
                return;
            }

            ClientEntity client = null;
            try {
                client = ClientEntityManager.selectById(id);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка получения данных: " + ex.getMessage());
                return;
            }

            if(client == null) {
                DialogUtil.showError(this, "Клиента с таким id не существует");
                return;
            }

            dispose();
            new ClientEditForm(client);
        });
    }
}
