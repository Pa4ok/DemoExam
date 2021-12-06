package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.BookEntity;
import ru.pa4ok.demoexam.manager.BookEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JButton clearFilterButton;

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
                    new String[]{ "ID", "Название", "Автор", "Страниц", "Дата написания" },
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
                    if(row != -1) {
                        dispose();
                        new BookEditForm(model.getRows().get(row));
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
            for(String a : authors) {
                authorFilterBox.addItem(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }

        pageFilterBox.addItem("Любое количество страниц");
        pageFilterBox.addItem("До 10 страниц");
        pageFilterBox.addItem("От 11 до 100 странимц");
        pageFilterBox.addItem("От 101 до 1000 страниц");
        pageFilterBox.addItem("Больше 1000 страниц");

        authorFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    applyFilters();
                }
            }
        });

        pageFilterBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
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

            int index = pageFilterBox.getSelectedIndex();
            if(index == 1) {
                list.removeIf(b -> b.getPages() > 10);
            } else if(index == 2) {
                list.removeIf(b -> b.getPages() < 11 || b.getPages() > 100);
            } else if(index == 3) {
                list.removeIf(b -> b.getPages() < 101 || b.getPages() > 1000);
            } else if(index == 4) {
                list.removeIf(b -> b.getPages() < 1001);
            }

            idSort = true;
            dateSort = false;

            model.setRows(list);
            model.fireTableDataChanged();

        } catch (SQLException ex) {
            ex.printStackTrace();
            DialogUtil.showError(BookTableForm.this, "Ошибка получения данных");
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

        clearFilterButton.addActionListener(e -> {
            authorFilterBox.setSelectedIndex(0);
            pageFilterBox.setSelectedIndex(0);
        });
    }
}