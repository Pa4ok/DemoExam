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
        super(800, 600);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        listButton.addActionListener(e -> {
            //dispose();
            new BookListForm(this);
        });

        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });

        editButton.addActionListener(e -> {
            int id = -1;
            try {
                id = Integer.parseInt(
                        JOptionPane.showInputDialog(this, "Введите id книжки", "Ввод", JOptionPane.QUESTION_MESSAGE)
                );
            } catch (Exception ex) {
                DialogUtil.showError(this, "Id введен неврено");
                return;
            }

            BookEntity book = null;

            try {
                book = BookEntityManager.selectById(id);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка получения данных: " + ex.getMessage());
                return;
            }

            if(book == null) {
                DialogUtil.showError(this, "Такой книжки не нет");
                return;
            }

            dispose();
            new BookEditForm(book);
        });
    }
}
