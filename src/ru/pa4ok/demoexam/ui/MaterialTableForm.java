package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.*;

public class MaterialTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton costSortButton;
    private JComboBox typeFilterBox;
    private JComboBox costFilterBox;
    private JLabel rowCountLabel;
    private JButton clearButton;

    private boolean costSort = false;

    private CustomTableModel<MaterialEntity> model;

    public MaterialTableForm()
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
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    MaterialEntity.class,
                    new String[] {
                            "ID", "Наименование", "Тип матерала", "Ед.изм.",
                            "Кол-во в упаковке", "Кол-во на складе", "Мин. кол-во",
                            "Цена", "Описание", "Путь до картинки", "Картинка"
                    },
                    MaterialEntityManager.selectAll()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

            updateRowCountLabel(model.getRowCount(), model.getRowCount());

            if(model.getRows().isEmpty()) {
                DialogUtil.showInfo(this, "В бд не найдено ни 1 записи");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка загрузки данных: " + e.getMessage());
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    if(row != -1) {
                        dispose();
                        new MaterialEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initBoxes()
    {
          try {
              Set<String> types = new HashSet<>();
              List<MaterialEntity> materials = MaterialEntityManager.selectAll();
              for(MaterialEntity m : materials) {
                  types.add(m.getType());
              }
              typeFilterBox.addItem("Все типы");
              for(String t : types) {
                  typeFilterBox.addItem(t);
              }
          } catch (Exception e) {
                DialogUtil.showError(this, "Ошибка получения данных");
          }

          typeFilterBox.addItemListener(e -> {
              if(e.getStateChange() == ItemEvent.SELECTED) {
                  updateFilters();
              }
          });

          costFilterBox.addItemListener(e -> {
              if(e.getStateChange() == ItemEvent.SELECTED) {
                  updateFilters();
              }
          });
    }

    private void updateFilters()
    {
        try {
            List<MaterialEntity> all = MaterialEntityManager.selectAll();
            int max = all.size();

            if(typeFilterBox.getSelectedIndex() != 0) {
                all.removeIf(material -> !material.getType().equals(typeFilterBox.getSelectedItem()));
            }

            switch (costFilterBox.getSelectedIndex())
            {
                case 1:
                    all.removeIf(material -> material.getCost() >= 5000);
                    break;
                case 2:
                    all.removeIf(material -> material.getCost() < 5000 || material.getCost() >= 15000);
                    break;
                case 3:
                    all.removeIf(material -> material.getCost() < 15000 || material.getCost() >= 50000);
                    break;
                case 4:
                    all.removeIf(material -> material.getCost() < 50000 || material.getCost() >= 100000);
                    break;
                case 5:
                    all.removeIf(material -> material.getCost() < 100000);
                    break;
            }

            model.setRows(all);
            model.fireTableDataChanged();

            updateRowCountLabel(all.size(), max);
            costSort = false;

            if(all.isEmpty()) {
                DialogUtil.showInfo(this, "Не найдено ни 1 записи подходящей под выбранные фильтры");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new MaterialCreateForm();
        });

        costSortButton.addActionListener(e -> {
            Collections.sort(model.getRows(), new Comparator<MaterialEntity>() {
                @Override
                public int compare(MaterialEntity o1, MaterialEntity o2) {
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

        clearButton.addActionListener(e -> {
            typeFilterBox.setSelectedIndex(0);
            costFilterBox.setSelectedIndex(0);
        });
    }

    private void updateRowCountLabel(int actual, int max)
    {
        rowCountLabel.setText("Записей: " + actual + " / " + max);
    }
}
