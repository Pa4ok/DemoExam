package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton testButton;

    private CreateBookForm createBookForm = new CreateBookForm(this);

    public MainForm()
    {
        super("123321", 400, 250);
        setContentPane(mainPanel);

        testButton.addActionListener(e -> {
            //dispose();
            //new CreateBookForm();
            setVisible(false);
            createBookForm.setVisible(true);
        });

        setVisible(true);
    }
}
