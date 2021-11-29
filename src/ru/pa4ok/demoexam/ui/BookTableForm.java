package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class BookTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton backButton;
    private JButton testButton;

    private CustomTableModel<BookEntity> model;

    public BookTableForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    BookEntity.class,
                    new String[]{ "ID", "Название", "Автор", "Страниц", "Дата написания" },
                    BookEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });

        testButton.addActionListener(e -> {
            System.out.println(model.getRows().get(3));
        });
    }
}
