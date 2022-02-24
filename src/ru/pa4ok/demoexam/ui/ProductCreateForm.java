package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class ProductCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField typeField;
    private JTextField articleField;
    private JTextField imageField;
    private JTextField costField;
    private JSpinner personCountSpinner;
    private JSpinner workshopNumberSpinner;
    private JButton backButton;
    private JButton saveButton;
    private JTextArea descArea;

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
