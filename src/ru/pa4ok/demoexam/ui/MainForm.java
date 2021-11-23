package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

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

        this.initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        listButton.addActionListener(e -> {
            dispose();
            new BookListForm();
        });

        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });

        editButton.addActionListener(e -> {
            int id = -1;
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите id", "Ввод", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception ex) {
                DialogUtil.showError(this, "Id не введен или введен неверно");
                return;
            }

            BookEntity book = null;
            try {
                book = BookEntityManager.selectById(id);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка получения данных: " + ex.getMessage());
                return;
            }

            if(book == null) {
                DialogUtil.showError(this, "Книжки с таким id не существует");
                return;
            }

            dispose();
            new BookEditForm(book);
        });
    }
}
