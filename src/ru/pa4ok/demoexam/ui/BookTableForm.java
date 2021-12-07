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
    private JComboBox<String> authorFilterBox;
    private JComboBox pageFilterBox;
    private JButton idSortButton;
    private JButton dateSortButton;
    private JButton clearButton;

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
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    BookEntity.class,
                    new String[] { "ID", "Название", "Автор", "Страниц", "Дата написания", "тест", "Изображение" },
                    BookEntityManager.selectAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка работы с бд");
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    new BookEditForm(BookTableForm.this, model.getRows().get(row));
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
            DialogUtil.showError(this, "Ошибка работы с бд");
        }

        authorFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    applyFilters();
                }
            }
        });

        pageFilterBox.addItem("Все");
        pageFilterBox.addItem(10);
        pageFilterBox.addItem(100);
        pageFilterBox.addItem(1000);

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
            List<BookEntity> allBooks = BookEntityManager.selectAll();

            if(authorFilterBox.getSelectedIndex() != 0) {
                allBooks.removeIf(b -> !b.getAuthor().equals(authorFilterBox.getSelectedItem()));
            }

            if(pageFilterBox.getSelectedIndex() != 0) {
                allBooks.removeIf(b -> b.getPages() < (int)pageFilterBox.getSelectedItem());
            }

            idSort = true;
            dateSort = false;

            model.setRows(allBooks);
            model.fireTableDataChanged();

        } catch (SQLException ex) {
            ex.printStackTrace();
            DialogUtil.showError(BookTableForm.this, "Ошибка работы с бд");
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            new BookCreateForm(this);
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

        clearButton.addActionListener(e -> {
            authorFilterBox.setSelectedIndex(0);
            pageFilterBox.setSelectedIndex(0);
        });
    }

    public CustomTableModel<BookEntity> getModel() {
        return model;
    }
}
