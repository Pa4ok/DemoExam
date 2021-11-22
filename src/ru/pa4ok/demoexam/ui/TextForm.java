package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class TextForm extends BaseSubForm<MainForm>
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public TextForm(MainForm mainForm)
    {
        super(mainForm, 600, 400);
        setContentPane(mainPanel);

        backButton.addActionListener(e -> {
            closeSubForm();
        });

        textArea.setEditable(false);

        try {
            List<BookEntity> list = BookEntityManager.selectAll();
            String s = "";
            for(BookEntity b : list) {
                s += b;
                s += "\n";
            }
            textArea.setText(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}
