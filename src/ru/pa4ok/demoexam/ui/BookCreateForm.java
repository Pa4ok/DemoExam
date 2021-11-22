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

public class BookCreateForm extends BaseForm
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

    //private MainForm mainForm;

    public BookCreateForm()//MainForm mainForm)
    {
        super(450, 250);
        //this.mainForm = mainForm;
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        for(int i=1; i<=31; i++) {
            dayBox.addItem(i);
        }
        for(int i=1940; i<=2021; i++) {
            yearBox.addItem(i);
        }
    }

    private void initButtons()
    {
        saveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 50) {
                DialogUtil.showError(this, "Название сликом корокткое или больше 50 символов");
                return;
            }

            String author = authorField.getText();
            if(author.isEmpty() || author.length() > 50) {
                DialogUtil.showError(this, "Автор сликом корокткий или больше 50 символов");
                return;
            }

            int pages = (int)pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество страниц введено неверно");
                return;
            }

            /*GregorianCalendar calendar = new GregorianCalendar();
            calendar.set((int)yearBox.getSelectedItem(), monthBox.getSelectedIndex(), (int)dayBox.getSelectedItem(), 0, 0, 0);
            Date date = calendar.getTime();*/

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, (int)yearBox.getSelectedItem());
            calendar.set(Calendar.MONTH, monthBox.getSelectedIndex());
            int days = (int)dayBox.getSelectedItem();
            if(days > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                DialogUtil.showError(this, "В этом месяце нет такого количества дней");
                return;
            }
            calendar.set(Calendar.DAY_OF_MONTH, days);
            Date date = calendar.getTime();

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.add(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo(this, "Книга добавлена успешно: " + book);
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
            //setVisible(false);
            //mainForm.setVisible(true);
        });
    }
}
