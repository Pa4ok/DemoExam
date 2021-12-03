package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.App;
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
import java.util.Date;

public class BookCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField dateField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JComboBox typeBox;
    private JButton backButton;

    public BookCreateForm()
    {
        super(450, 250);
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        typeBox.addItem("FIRST");
        typeBox.addItem("SECOND");
        typeBox.addItem("THIRD");
    }

    private void initButtons()
    {
        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 50) {
                DialogUtil.showError(this, "Название не введено или оно слишком длинное");
                return;
            }

            String author = authorField.getText();
            if(author.isEmpty() || author.length() > 50) {
                DialogUtil.showError(this, "Автор не введен или он слишком длинный");
                return;
            }

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                DialogUtil.showError(this, "Количество стриниц ввдено неверно");
                return;
            }

            Date date = null;
            try {
                date = App.DATE_FORMAT.parse(dateField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Дата введена в неправильно, корректный формат: " + App.DATE_FORMAT.toLocalizedPattern());
                return;
            }

            BookEntity book = new BookEntity(title, author, pages, date, (String) typeBox.getSelectedItem());

            try {
                BookEntityManager.insert(book);
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Ошибка сохранения данных");
                ex.printStackTrace();
                return;
            }

            DialogUtil.showInfo(this, "Книжка успешно добавлена");
            dispose();
            new BookTableForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new BookTableForm();
        });
    }
}
