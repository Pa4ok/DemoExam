package ru.pa4ok.guide.ui;

import ru.pa4ok.guide.entity.ClientEntity;
import ru.pa4ok.guide.manager.ClientEntityManager;
import ru.pa4ok.guide.util.BaseForm;
import ru.pa4ok.guide.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ClientTextListForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public ClientTextListForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        initText();
        initButtons();

        setVisible(true);
    }

    private void initText()
    {
        textArea.setEditable(false);

        try {
            List<ClientEntity> list = ClientEntityManager.selectAll();
            String s = "";
            for(ClientEntity c : list) {
                s += c;
                s += "\n";
            }
            textArea.setText(s);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
