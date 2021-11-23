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
import java.util.Date;

public class BookCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField dateField;
    private JButton saveButton;
    private JSpinner pageSpinner;

    public BookCreateForm()
    {
        super(450, 250);
        setContentPane(mainPanel);

        /*saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //...
            }
        });

        saveButton.addActionListener(e -> {
            //...
        });
        */

        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 50) {
                System.out.println("Название не введено или оно слишком длинное");
                return;
            }

            String author = authorField.getText();
            if(author.isEmpty() || author.length() > 50) {
                System.out.println("Автор не введен или он слишком длинный");
                return;
            }

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                System.out.println("Количество стриниц ввдено неверно");
                return;
            }

            Date date = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                date = format.parse(dateField.getText());
            } catch (Exception ex) {
                System.out.println("Дата введена в неправильно, корректный формат: dd.MM.yyyy hh:mm");
                return;
            }

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.insert(book);
            } catch (SQLException ex) {
                System.out.println("Ошибка сохранения данных");
                ex.printStackTrace();
                return;
            }

            System.out.println("Книжка успешно добавлена");
        });

        setVisible(true);
    }
}
