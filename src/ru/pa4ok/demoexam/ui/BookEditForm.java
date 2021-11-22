package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseSubForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookEditForm extends BaseSubForm<MainForm>
{
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField titleField;
    private JTextField authorField;
    private JSpinner pageSpinner;
    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;
    private JButton saveButton;
    private JButton backButton;

    private BookEntity book;

    public BookEditForm(MainForm mainForm, BookEntity book)
    {
        super(mainForm, 400, 250);
        this.book = book;
        setContentPane(mainPanel);

        initFields();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setText(String.valueOf(book.getId()));
        idField.setEnabled(false);
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        pageSpinner.setValue(book.getPages());
    }

    private void initBoxes()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(book.getWriteDateTime());

        for(int i=1; i<=31; i++) {
            dayBox.addItem(i);
        }
        dayBox.setSelectedItem(calendar.get(Calendar.DAY_OF_MONTH));

        for(int i=2001; i>=1970; i--) {
            yearBox.addItem(i);
        }
        yearBox.setSelectedItem(calendar.get(Calendar.YEAR));

        monthBox.setSelectedIndex(calendar.get(Calendar.MONTH));
    }

    private void initButtons()
    {
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
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (Integer) dayBox.getSelectedItem(), 0, 0);
            Date date = calendar.getTime();

            book.setTitle(title);
            book.setAuthor(author);
            book.setPages(pages);
            book.setWriteDateTime(date);

            try {
                BookEntityManager.update(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo("Книжка успешно сохранена");
            closeSubForm();
        });

        backButton.addActionListener(e -> {
            closeSubForm();
        });
    }
}