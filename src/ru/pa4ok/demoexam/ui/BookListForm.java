package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class BookListForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public BookListForm()
    {
        super(600, 400);
        setContentPane(mainPanel);

        this.initText();
        this.initButtons();

        setVisible(true);
    }

    private void initText()
    {
        textArea.setEditable(false);

        try {
            List<BookEntity> list = BookEntityManager.selectAll();
            StringBuilder sb = new StringBuilder();
            for(BookEntity b : list) {
                sb.append(b).append("\n");
            }
            textArea.setText(sb.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка подключения к бд");
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
