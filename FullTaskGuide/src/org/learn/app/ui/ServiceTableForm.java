package org.learn.app.ui;

import org.learn.app.App;
import org.learn.app.entity.ServiceEntity;
import org.learn.app.manager.ServiceEntityManager;
import org.learn.app.util.BaseForm;
import org.learn.app.util.CustomTableModel;
import org.learn.app.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * форма со списокм услуг
 */
public class ServiceTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton costSortButton;
    private JComboBox discountFilterBox;
    private JLabel rowCountLabel;
    private JButton clearFilterButton;
    private JButton helpButton;
    private JButton dealButton;
    private JButton clientServiceTableButton;

    private CustomTableModel<ServiceEntity> model;

    private boolean costSort = false;

    public ServiceTableForm()
    {
        super(1200, 800);
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
                    new String[]{ "ID", "Название", "Длительность", "Стоимость", "Скидка", "Описание", "Путь до картинки", "Картинка" },
                    ServiceEntityManager.selectAll()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

            updateRowCountLabel(model.getRows().size(), model.getRows().size());

            if(model.getRows().isEmpty()) {
                DialogUtil.showInfo(this, "В базе данных не найдено ни 1 записи");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }

        if(App.ADMIN_MODE) {
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
    }

    private void initBoxes()
    {
        discountFilterBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
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

            if(list.isEmpty()) {
                DialogUtil.showInfo(this, "В базе данных не найдено ни 1 записи");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }
    }

    private void initButtons()
    {
        if(App.ADMIN_MODE) {
            addButton.addActionListener(e -> {
                dispose();
                new ServiceCreateForm();
            });
        } else {
            addButton.setEnabled(false);
        }

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
        rowCountLabel.setText("Отображено записей: " + actual + " / " + max);
    }
}
