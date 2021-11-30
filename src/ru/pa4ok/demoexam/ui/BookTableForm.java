package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class BookTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JComboBox authorFilterBox;
    private JComboBox pageFilterBox;
    private JButton idSortButton;
    private JButton dateSortButton;

    private CustomTableModel<BookEntity> model;

    private boolean idSort = true;
    private boolean dateSort = false;

    public BookTableForm()
    {
        super(800, 600);
        setContentPane(mainPanel);

        initTable();
        initBoxes();
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
                                model.fireTableDataChanged();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    private void initBoxes()
    {
        authorFilterBox.addItem("Все авторы");
        try {
            List<BookEntity> list = BookEntityManager.selectAll();
            Set<String> authors = new HashSet<>();
            for(BookEntity b : list) {
                authors.add(b.getAuthor());
            }
            for(String s : authors) {
                authorFilterBox.addItem(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        authorFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    applyFilters();
                }
            }
        });

        pageFilterBox.addItem("Все книги");
        pageFilterBox.addItem(10);
        pageFilterBox.addItem(100);
        pageFilterBox.addItem(1000);
        pageFilterBox.addItem(10000);

        pageFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    applyFilters();
                }
            }
        });
    }

    private void applyFilters()
    {
        try {
            List<BookEntity> list = BookEntityManager.selectAll();

            if(authorFilterBox.getSelectedIndex() != 0) {
                list.removeIf(b -> !b.getAuthor().equals(authorFilterBox.getSelectedItem()));
            }

            if(pageFilterBox.getSelectedIndex() != 0) {
                list.removeIf(b -> b.getPages() < (int)pageFilterBox.getSelectedItem());
            }

            idSort = true;
            dateSort = false;

            model.setRows(list);
            model.fireTableDataChanged();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new BookCreateForm();
        });

        idSortButton.addActionListener(e -> {
            Collections.sort(model.getRows(), new Comparator<BookEntity>() {
                @Override
                public int compare(BookEntity o1, BookEntity o2) {
                    if(idSort) {
                        return Integer.compare(o2.getId(), o1.getId());
                    } else {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
            });

            idSort = !idSort;
            dateSort = false;

            model.fireTableDataChanged();
        });

        dateSortButton.addActionListener(e -> {
            Collections.sort(model.getRows(), new Comparator<BookEntity>() {
                @Override
                public int compare(BookEntity o1, BookEntity o2) {
                    if(dateSort) {
                        return o2.getWriteDateTime().compareTo(o1.getWriteDateTime());
                    } else {
                        return o1.getWriteDateTime().compareTo(o2.getWriteDateTime());
                    }
                }
            });

            dateSort = !dateSort;
            idSort = false;

            model.fireTableDataChanged();
        });
    }
}
