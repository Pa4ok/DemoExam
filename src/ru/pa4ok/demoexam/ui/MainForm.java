package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton listButton;
    private JButton addButton;

    //private CreateBookForm createBookForm = new CreateBookForm(this);

    public MainForm()
    {
        super(600, 400);
        setContentPane(mainPanel);

        this.initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        listButton.addActionListener(e -> {
            dispose();
            new BookListForm();
        });

        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
            //setVisible(false);
            //createBookForm.setVisible(true);
        });
    }
}
