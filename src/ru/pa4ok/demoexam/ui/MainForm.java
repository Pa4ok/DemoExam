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
    private JButton addButton;
    private JButton bookListButton;
    private JButton editBookButton;

    public MainForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        bookListButton.addActionListener(e -> {
            //new TextForm(this);
            dispose();
            new BookTableForm();
        });

        addButton.addActionListener(e -> {
            new BookCreateForm(this);
        });

        editBookButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this, "Введите id книги для редактирования");
            if(s == null || s.isEmpty()) {
                DialogUtil.showError(this, "Id не введен");
                return;
            }

            int id = -1;
            try {
                id = Integer.parseInt(s);
            } catch (Exception ex) {
                DialogUtil.showError(this, "Id введен неверно");
                return;
            }

            try {
                BookEntity book = BookEntityManager.selectById(id);
                if(book == null) {
                    DialogUtil.showError(this, "Книга с таким id не найдена");
                    return;
                }

                new BookEditForm(this, book);

            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка запроса к базе: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
