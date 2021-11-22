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
            new BookListForm(this);
        });

        addButton.addActionListener(e -> {
            new BookCreateForm(this);
        });

        editButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this, "Введите id книги");
            if(s.isEmpty()) {
                DialogUtil.showError(this, "Id не введен");
                return;
            }

            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception ex) {
                DialogUtil.showError(this, "Id введен некоретно");
                return;
            }

            BookEntity book = null;
            try {
                book = BookEntityManager.selectById(id);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка подключения к базе данных: " + ex.getMessage());
                return;
            }

            if(book == null) {
                DialogUtil.showError(this, "Такой книжки не найдено");
                return;
            }

            new BookEditForm(this, book);
        });
    }
}
