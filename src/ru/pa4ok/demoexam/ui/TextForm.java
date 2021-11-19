package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public TextForm()
    {
        super("текст", 600, 400);
        setContentPane(mainPanel);
        backButton.addActionListener(e -> {
            setVisible(false);
            App.mainForm.setVisible(true);
        });

        try {
            List<BookEntity> books = BookEntityManager.selectAll();
            StringBuilder sb = new StringBuilder();
            for(BookEntity b : books) {
                sb.append(b).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
