package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MainForm extends BaseForm
{
    private JButton addButton;
    private JPanel mainPanel;
    private JButton listButton;
    private JButton editButton;

    public MainForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        listButton.addActionListener(e -> {
            dispose();
            new BookTextListForm();
        });

        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });

        editButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this, "Введите id книжки", "Ввод", JOptionPane.QUESTION_MESSAGE);
            if(s == null) {
                return;
            }

            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception ex) {
                DialogUtil.showError(this, "ID не введен или введен неверно");
                return;
            }

            BookEntity book = null;
            try {
                book = BookEntityManager.selectById(id);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка получения данных");
                return;
            }

            if(book == null) {
                DialogUtil.showError(this, "Книжки с таким ID не найдено");
                return;
            }

            dispose();
            new BookEditForm(book);
        });
    }
}
