package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ServiceEntity;
import ru.pa4ok.demoexam.manager.ServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton costSortButton;
    private JComboBox discountFilterBox;
    private JButton clearFilterButton;
    private JLabel rowCountLabel;
    private JButton helpButton;
    private JButton dealButton;
    private JButton clientServiceTableButton;

    private CustomTableModel<ServiceEntity> model;

    private boolean costSort = false;

    public ServiceTableForm()
    {
        super(1000, 600);
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
                    ServiceEntity.class,
                    new String[] { "ID", "Название", "Длительность", "Стоимость", "Скидка", "Описание", "Путь до картинки", "Картинка" },
                    ServiceEntityManager.selectAll()
            );
            table.setModel(model);

            updateRowCountLabel(model.getRowCount(), model.getRowCount());

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    if(row != -1) {
                        dispose();
                        new ServiceEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initBoxes()
    {
        discountFilterBox.addItemListener(new ItemListener() {
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
            List<ServiceEntity> list = ServiceEntityManager.selectAll();
            int max = list.size();

            switch (discountFilterBox.getSelectedIndex())
            {
                case 1:
                    list.removeIf(s -> s.getDiscount() >= 5);
                    break;
                case 2:
                    list.removeIf(s -> s.getDiscount() < 5 || s.getDiscount() >= 15);
                    break;
                case 3:
                    list.removeIf(s -> s.getDiscount() < 15 || s.getDiscount() >= 30);
                    break;
                case 4:
                    list.removeIf(s -> s.getDiscount() < 30 || s.getDiscount() >= 70);
                    break;
                case 5:
                    list.removeIf(s -> s.getDiscount() < 70);
                    break;
            }

            model.setRows(list);
            model.fireTableDataChanged();

            costSort = false;
            updateRowCountLabel(list.size(), max);

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new ServiceCreateForm();
        });

        costSortButton.addActionListener(e -> {
            Collections.sort(model.getRows(), new Comparator<ServiceEntity>() {
                @Override
                public int compare(ServiceEntity o1, ServiceEntity o2) {
                    if(costSort) {
                        return Double.compare(o2.getCost(), o1.getCost());
                    } else {
                        return Double.compare(o1.getCost(), o2.getCost());
                    }
                }
            });
            costSort = !costSort;
            model.fireTableDataChanged();
        });

        clearFilterButton.addActionListener(e -> {
            discountFilterBox.setSelectedIndex(0);
        });

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование - двойной клик по записи\nУдаление - внутри формы редактирования");
        });

        dealButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связаться с разработчиком можно по почте vasya_2008@mail.ru");
        });

        clientServiceTableButton.addActionListener(e -> {
            dispose();
            new ClientServiceTableForm();
        });
    }

    private void updateRowCountLabel(int actual, int max)
    {
        rowCountLabel.setText("Записей: " + actual + " / " + max);
    }
}
