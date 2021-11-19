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
    private JTextField pageField;
    private JTextField dateField;
    private JButton saveButton;

    public BookCreateForm()
    {
        super("My super app", 450, 250);
        setContentPane(mainPanel);

        /*
        //вариант 1
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //...
            }
        });

        //вариант 2
        saveButton.addActionListener(e -> {
            //...
        });*/

        saveButton.addActionListener(e ->
        {
            String title = titleField.getText();
            String author = authorField.getText();

            int pages = 0;
            try {
                pages = Integer.parseInt(pageField.getText());
            } catch (Exception ex) {
                System.out.println("Количество страниц введено неверно");
                return;
            }

            Date date = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                date = format.parse(dateField.getText());
            } catch (Exception ex) {
                System.out.println("Дата введена неверно, правильный формат: dd.MM.yyyy hh:mm");
                return;
            }

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
