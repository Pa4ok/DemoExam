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
import java.util.function.Predicate;

/**
 * форма со списком книжек
 */
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
    private JLabel rowCountLabel;
    private JButton helpButton;
    private JButton dealButton;

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
                    new String[] { "ID", "Название", "Автор", "Страниц", "Дата написания", "Жанр", "Картинка" },
                    BookEntityManager.selectAll()
            );
            table.setModel(model);

            updateRowCountLabel(model.getRows().size(), model.getRows().size());

            if(model.getRows().isEmpty()) {
                DialogUtil.showInfo(this, "В базе данных не обнаружено ни 1 записи");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
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
        }

        pageFilterBox.addItem("Любое количество страниц");
        pageFilterBox.addItem("До 10 страниц");
        pageFilterBox.addItem("От 11 до 100 страниц");
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
            int max = list.size();

            if(authorFilterBox.getSelectedIndex() != 0) {
                list.removeIf(b -> !b.getAuthor().equals(authorFilterBox.getSelectedItem()));
            }

            int index = pageFilterBox.getSelectedIndex();
            if(index == 1) {
                list.removeIf(b -> b.getPages() > 10);
            } else if(index == 2) {
                list.removeIf(b -> b.getPages() <= 10 || b.getPages() > 100);
            } else if(index == 3) {
                list.removeIf(b -> b.getPages() <= 100 || b.getPages() > 1000);
            } else if(index == 4) {
                list.removeIf(b -> b.getPages() <= 1000);
            }

            idSort = true;
            dateSort = false;

            model.setRows(list);
            model.fireTableDataChanged();

            updateRowCountLabel(list.size(), max);

            if(model.getRows().isEmpty()) {
                DialogUtil.showInfo(this, "В базе данных не обнаружено ни 1 записи подходящей под выбранные фильтры");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + ex.getMessage());
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

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование - двойной клик по записи\nУдаление - внутри формы редактирования");
        });

        dealButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связаться с разработчиком можно по почте vasya_8b@mail.ru");
        });
    }

    private void updateRowCountLabel(int actual, int max)
    {
        rowCountLabel.setText("Записей: " + actual + " / " + max);
    }
}
