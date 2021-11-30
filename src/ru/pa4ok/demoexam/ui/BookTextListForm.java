package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class BookTextListForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;

    public BookTextListForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        initText();
        initButtons();

        setVisible(true);
    }

    private void initText()
    {
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
            DialogUtil.showError(this, "Ошибка получения данных");
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
