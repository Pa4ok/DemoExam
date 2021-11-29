package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class BookTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;

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
                    new String[] { "ID", "Название", "Автор", "Страниц", "Дата написания" },
                    BookEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    dispose();
                    new BookEditForm(model.getRows().get(row));
                }
            }
        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int row = table.getSelectedRow();
                    if(row != -1) {
                        if(JOptionPane.showConfirmDialog(
                                BookTableForm.this,
                                "Вы точно хотите удалить данную запись?",
                                "Подтверждение",
                                JOptionPane.YES_NO_OPTION
                        ) == JOptionPane.YES_OPTION) {
                            try {
                                BookEntityManager.delete(model.getRows().get(row));
                                model.getRows().remove(row);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });
    }
}
