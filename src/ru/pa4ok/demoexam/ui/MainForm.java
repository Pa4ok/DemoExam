package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.App;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private JButton addBookButton;
    private JPanel mainPanel;
    private JButton textButton;

    public MainForm()
    {
        super("Тест форма", 400, 250);
        setContentPane(mainPanel);
        addBookButton.addActionListener(e -> {
            //dispose();
            //new BookCreateForm();
            setVisible(false);
            App.bookCreateForm.setVisible(true);
        });
        //setVisible(true);

        textButton.addActionListener(e -> {
            setVisible(false);
            App.textForm.setVisible(true);
        });
    }
}
