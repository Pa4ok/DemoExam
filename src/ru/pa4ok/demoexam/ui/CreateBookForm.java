package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateBookForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField pageField;
    private JTextField dateField;
    private JButton saveButton;

    public CreateBookForm()
    {
        super("My super application", 450, 250);
        setContentPane(mainPanel);

        /*//вариант 1
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
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                date = format.parse(dateField.getText());
            } catch (Exception ex) {
                System.out.println("Дата введена неверно, правильный формат: dd.MM.yyyy");
                return;
            }

            BookEntity book = new BookEntity(title, author, pages, date);

            try {
                BookEntityManager.add(book);
            } catch (SQLException ex) {
                System.out.println("Ошибка сохранения данных " + ex.getMessage());
                ex.printStackTrace();
                return;
            }

            System.out.println("Книга добавлена успешно: " + book);
        });

        setVisible(true);
    }
}
