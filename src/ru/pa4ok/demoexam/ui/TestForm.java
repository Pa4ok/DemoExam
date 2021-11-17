package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class TestForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton testButton;

    public TestForm()
    {
        super(400, 300);
        setContentPane(mainPanel);

        testButton.addActionListener(e -> {
            setVisible(false);
            //setEnabled(false);
            //dispose();
            new BookCreateForm(this);
        });

        setVisible(true);
    }
}
