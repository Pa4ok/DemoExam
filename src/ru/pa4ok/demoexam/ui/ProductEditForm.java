package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class ProductEditForm extends BaseForm
{
    private JTextField textField1;
    private JButton backButton;
    private JPanel mainPanel;

    public ProductEditForm()
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
