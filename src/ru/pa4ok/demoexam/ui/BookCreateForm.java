package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JComboBox<Integer> monthBox;
    private JComboBox<Integer> yearBox;
    private JComboBox<Integer> dayBox;
    private JButton backButton;

    public BookCreateForm()
    {
        super(450, 250);
        setContentPane(mainPanel);

        this.initBoxes();
        this.initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        for(int i=1; i<=31; i++) {
            dayBox.addItem(i);
        }

        for(int i=1980; i<2021; i++) {
            yearBox.addItem(i);
        }
    }

    private void initButtons()
    {
        saveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            String author = authorField.getText();

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Неверно введено количество страниц");
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (int)dayBox.getSelectedItem());
            Date date = calendar.getTime();

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.insert(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo(this, "Книга успешно добавлена");
            dispose();
            new BookTableForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new BookTableForm();
        });
    }
}
