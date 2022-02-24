package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.Application;
import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class ProductCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton backButton;

    public ProductCreateForm()
    {
        super(400, 400);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
        });
    }
}
