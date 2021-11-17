package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;
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
        super("Школа языков Леарн", 450, 250);
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

            int pages = (int) pageSpinner.getValue();
            if(pages <= 0) {
                System.out.println("Количество страниц введено неверно");
                return;
            }

            Date date = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                date = format.parse(dateField.getText());
            } catch (Exception ex) {
                System.out.println("Дата введена неверно, правильный формат: yyyy-MM-dd hh:mm");
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

            System.out.println("Кгига успешно добавлена: " + book);
        });

        setVisible(true);
    }
}
