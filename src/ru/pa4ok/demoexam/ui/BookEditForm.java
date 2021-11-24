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
    private JButton deleteButton;

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
            String title = titleField.getText();
            if(title.length() > 50) {
                DialogUtil.showError(this, "Слишком длинное название");
                return;
            }

            String author = authorField.getText();

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество страниц введено неверно");
                return;
            }

            /*GregorianCalendar calendar = new GregorianCalendar();
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (Integer) dayBox.getSelectedItem());
            Date date = calendar.getTime();*/

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, (int)yearBox.getSelectedItem());
            calendar.set(Calendar.MONTH, monthBox.getSelectedIndex());
            int day = (int) dayBox.getSelectedItem();
            if(day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                DialogUtil.showError(this, "В этом месяце нет такого количества дней");
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
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка обновления данных: " + ex.getMessage());
                return;
            }

            DialogUtil.showInfo(this, "Кгига успешно отредактирована");
            dispose();
            new MainForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });

        deleteButton.addActionListener(e ->
        {
            if(JOptionPane.showConfirmDialog(
                    this,
                    "Вы точно хотите удалить данную запись",
                    "Подтверждение",
                    JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                try {
                    BookEntityManager.delete(book);
                    DialogUtil.showInfo(this, "Кгига успешно удалена");
                    dispose();
                    new MainForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });
    }
}
