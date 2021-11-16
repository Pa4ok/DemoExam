package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;
import java.util.Random;

public class TestNewForm extends BaseForm
{
    private JPanel mainPenel;
    private JButton testButton;
    private JTextArea textArea1;

    public TestNewForm()
    {
        super("123", 300, 100);
        setContentPane(mainPenel);

        testButton.addActionListener(e -> {
            this.dispose();
            new CreateBookForm();
        });

        setVisible(true);
    }
}
