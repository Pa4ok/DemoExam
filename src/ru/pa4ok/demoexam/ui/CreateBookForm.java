package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreateBookForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;
    private JButton backButton;

    private MainForm mainForm;

    public CreateBookForm(MainForm mainForm)
    {
        super("My super application", 420, 250);
        this.mainForm = mainForm;
        setContentPane(mainPanel);

        for(int i=1; i<=31; i++) {
            dayBox.addItem(i);
        }
        for(int i=1940; i<=2021; i++) {
            yearBox.addItem(i);
        }

        saveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            String author = authorField.getText();

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество страниц введено неверно");
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (int)dayBox.getSelectedItem(), 0, 0);
            Date date = calendar.getTime();

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.insert(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            System.out.println("Книга успешно добавлена: " + book);
        });

        backButton.addActionListener(e -> {
            //dispose();
            //new MainForm();
            setVisible(false);
            mainForm.setVisible(true);
        });
    }
}