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

public class CreateBookForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JButton saveButton;
    private JSpinner pageSpinner;
    private JTextField dateField;

    public CreateBookForm()
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

            Date date = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                date = format.parse(dateField.getText());
            } catch (Exception ex) {
                System.out.println("Неверный формат даты, правильный формат: dd-MM-yyyy HH:mm");
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
