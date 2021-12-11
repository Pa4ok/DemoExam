package ru.pa4ok.guide.ui;

import ru.pa4ok.guide.entity.ClientEntity;
import ru.pa4ok.guide.manager.ClientEntityManager;
import ru.pa4ok.guide.util.BaseForm;
import ru.pa4ok.guide.util.CustomTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.*;

public class ClientTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JComboBox genderFilterBox;
    private JComboBox nameFilterBox;
    private JButton clearFilterButton;
    private JLabel rowCountLabel;
    private JButton idSortButton;
    private JButton dateSortButton;

    private CustomTableModel<ClientEntity> model;

    private boolean idSort = true;
    private boolean dateSort = false;

    public ClientTableForm()
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
                    ClientEntity.class,
                    new String[] { "ID", "Имя", "Фамилия", "Отчество", "Дата рождения", "Дата регистрации", "Email", "Телефон", "Гендер", "Путь до картинки", "Картинка" },
                    ClientEntityManager.selectAll()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

            updateRowCountLabel(model.getRows().size(), model.getRows().size());

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
                        new ClientEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initBoxes()
    {
        genderFilterBox.addItem("Все");
        genderFilterBox.addItem("Мужской");
        genderFilterBox.addItem("Женский");

        genderFilterBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    applyFilters();
                }
            }
        });

        nameFilterBox.addItem("Все");
        try {
            List<ClientEntity> list = ClientEntityManager.selectAll();
            Set<String> names = new HashSet<>();
            for(ClientEntity c : list) {
                names.add(c.getFirstname());
            }
            for(String s : names) {
                nameFilterBox.addItem(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nameFilterBox.addItemListener(new ItemListener() {
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
            List<ClientEntity> list = ClientEntityManager.selectAll();
            int max = list.size();

            int index = genderFilterBox.getSelectedIndex();
            if(index == 1) {
                list.removeIf(c -> c.getGender() != 'м');
            } else if(index == 2) {
                list.removeIf(c -> c.getGender() != 'ж');
            }

            if(nameFilterBox.getSelectedIndex() != 0) {
                list.removeIf(c -> !c.getFirstname().equals(nameFilterBox.getSelectedItem()));
            }

            model.setRows(list);
            model.fireTableDataChanged();

            idSort = true;
            dateSort = false;

            updateRowCountLabel(list.size(), max);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new ClientCreateForm();
        });

        clearFilterButton.addActionListener(e -> {
            genderFilterBox.setSelectedIndex(0);
            nameFilterBox.setSelectedIndex(0);
        });

        idSortButton.addActionListener(e -> {
            Collections.sort(model.getRows(), new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
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
            Collections.sort(model.getRows(), new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(dateSort) {
                        return o2.getBirthday().compareTo(o1.getBirthday());
                    } else {
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                }
            });
            dateSort = !dateSort;
            idSort = false;
            model.fireTableDataChanged();
        });
    }

    private void updateRowCountLabel(int actual, int max)
    {
        rowCountLabel.setText("Отображено записей: " + actual + " / " + max);
    }
}
