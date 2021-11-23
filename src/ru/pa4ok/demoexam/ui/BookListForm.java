package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.BaseSubForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class BookListForm extends BaseSubForm<MainForm>
{
    private JPanel mainPanel;
    private JButton backButton;
    private JTextArea textArea;

    public BookListForm(MainForm mainForm)
    {
        super(mainForm, 600, 400);
        setContentPane(mainPanel);

        this.initText();
        this.initButtons();

        setVisible(true);
    }

    private void initText()
    {
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
            DialogUtil.showError(this, "Ошибка работы с бд: " + e.getMessage());
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            closeSubForm();
        });
    }
}
