package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class BookListForm extends BaseSubForm<MainForm>
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public BookListForm(MainForm mainForm)
    {
        super(mainForm, 600, 400);
        setContentPane(mainPanel);

        initText();
        initButtons();

        setVisible(true);
    }

    private void initText()
    {
        textArea.setEditable(false);

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

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            //dispose();
            //new MainForm();
            closeSubForm();
        });
    }
}
