package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public CreateBookForm()
    {
        super("My super app", 450, 250);
        setContentPane(mainPanel);

        for(int i=1; i<=31; i++) {
            dayBox.addItem(i);
        }
        for(int i=1940; i<=2021; i++) {
            yearBox.addItem(i);
        }

        saveButton.addActionListener(e ->
        {
            String title = titleField.getText().trim();
            if(title.isEmpty() || title.length() > 256) {
                System.out.println("Слишком короткое или длинное название");
                return;
            }

            String author = authorField.getText().trim();
            if(author.isEmpty() || author.length() > 256) {
                System.out.println("Слишком длинный или короткий автор");
                return;
            }

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                System.out.println("Количество страниц введено неверно");
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
                System.out.println("В этом месяце нет столько дней");
                return;
            }
            calendar.set(Calendar.DAY_OF_MONTH, day);
            Date date = calendar.getTime();

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.insert(book);
            } catch (SQLException ex) {
                System.out.println("Ошибка сохранения данных: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            System.out.println("Книга успешно добавлена: " + book);
        });

        setVisible(true);
    }
}
