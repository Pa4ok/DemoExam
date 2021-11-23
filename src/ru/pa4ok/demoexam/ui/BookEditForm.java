package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookEditForm extends BaseForm
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
    private JTextField idField;

    private BookEntity book;

    public BookEditForm(BookEntity book)
    {
        super(450, 250);
        this.book = book;
        setContentPane(mainPanel);

        initFields();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(book.getId()));
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

        for(int i=1940; i<=2021; i++) {
            yearBox.addItem(i);
        }
        yearBox.setSelectedItem(calendar.get(Calendar.YEAR));

        monthBox.setSelectedIndex(calendar.get(Calendar.MONTH));
    }

    private void initButtons()
    {
        saveButton.addActionListener(e ->
        {
            String title = titleField.getText().trim();
            if(title.isEmpty() || title.length() > 256) {
                DialogUtil.showError(this, "Слишком короткое или длинное название");
                return;
            }

            String author = authorField.getText().trim();
            if(author.isEmpty() || author.length() > 256) {
                DialogUtil.showError(this, "Слишком длинный или короткий автор");
                return;
            }

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество страниц введено неверно");
                return;
            }

            /*GregorianCalendar calendar = new GregorianCalendar();
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (int)dayBox.getSelectedItem());
            Date date = calendar.getTime();*/

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, (int)yearBox.getSelectedItem());
            calendar.set(Calendar.MONTH, monthBox.getSelectedIndex());
            int day = (int)dayBox.getSelectedItem();
            if(day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                DialogUtil.showError(this, "В этом месяце нет столько дней");
                return;
            }
            calendar.set(Calendar.DAY_OF_MONTH, day);
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

            DialogUtil.showInfo(this, "Книга успешно изменена");

            dispose();
            new MainForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
