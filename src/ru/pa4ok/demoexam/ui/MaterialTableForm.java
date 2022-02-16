package ru.pa4ok.demoexam.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

public class MaterialTableForm extends BaseForm {
    private Path configPath = Paths.get("config.json");
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Config config;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton costSortButton;
    private JComboBox typeFilterBox;
    private JComboBox costFilterBox;
    private JLabel rowCountLabel;
    private JButton clearButton;
    private JButton helpButton;
    private JButton dealButton;

    private CustomTableModel<MaterialEntity> model;

    private boolean costSort = false;

    public MaterialTableForm() {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();
        initConfig();

        setVisible(true);
    }

    private void initConfig()
    {
        loadConfig();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveConfig();
            }
        });
    }

    private void initTable() {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    MaterialEntity.class,
                    new String[]{
                            "ID", "Наименование", "Тип материала", "Ед. изм.",
                            "Цена", "Кол-во в упаковке", "Кол-во на складе", "Мин. кол-во",
                            "Описание", "Путь до картинки", "Картинка"
                    },
                    MaterialEntityManager.selectAll()
            );
            table.setModel(model);

            TableColumn column = table.getColumn("Путь до картинки");
            column.setMinWidth(0);
            column.setPreferredWidth(0);
            column.setMaxWidth(0);

            updateRowCountLabel(model.getRowCount(), model.getRowCount());
            if (model.getRowCount() == 0) {
                DialogUtil.showInfo(this, "В бд не найдено ни 1 записи");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row != -1) {
                        dispose();
                        new MaterialEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initBoxes() {
        try {
            List<MaterialEntity> list = MaterialEntityManager.selectAll();
            Set<String> types = new HashSet<>();
            for (MaterialEntity m : list) {
                types.add(m.getMaterialType());
            }
            typeFilterBox.addItem("Все типы");
            for (String t : types) {
                typeFilterBox.addItem(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }

        typeFilterBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
            }
        });

        costFilterBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
            }
        });
    }

    private void applyFilters() {
        try {
            List<MaterialEntity> all = MaterialEntityManager.selectAll();
            int max = all.size();

            if (typeFilterBox.getSelectedIndex() != 0) {
                all.removeIf(material -> !material.getMaterialType().equals(typeFilterBox.getSelectedItem()));
            }

            switch (costFilterBox.getSelectedIndex()) {
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

            if (all.isEmpty()) {
                DialogUtil.showInfo(this, "Не найдено ни 1 запиди подходящей под фильтры");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }
    }

    private void initButtons() {
        addButton.addActionListener(e -> {
            dispose();
            new MaterialCreateForm();
        });

        costSortButton.addActionListener(e -> {
            applyCostSort();
        });

        clearButton.addActionListener(e -> {
            typeFilterBox.setSelectedIndex(0);
            costFilterBox.setSelectedIndex(0);
        });

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование - двойной клик по записи\nУдаление - вунтри формы редактирования");
        });

        dealButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связь с разработчиком: anton-2008@mail.ru");
        });
    }

    private void applyCostSort()
    {
        Collections.sort(model.getRows(), new Comparator<MaterialEntity>() {
            @Override
            public int compare(MaterialEntity o1, MaterialEntity o2) {
                if (costSort) {
                    return Double.compare(o2.getCost(), o1.getCost());
                } else {
                    return Double.compare(o1.getCost(), o2.getCost());
                }
            }
        });
        costSort = !costSort;
        model.fireTableDataChanged();
    }

    private void updateRowCountLabel(int actual, int max) {
        rowCountLabel.setText("Записей: " + actual + " / " + max);
    }

    private void loadConfig()
    {
        try {
            if (Files.exists(configPath)) {
                config = gson.fromJson(Files.readString(configPath), Config.class);
                typeFilterBox.setSelectedIndex(config.getTypeFilterIndex());
                costFilterBox.setSelectedIndex(config.getCostFilterIndex());
                if(config.isCostSort()) {
                    applyCostSort();
                }
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка загрузки конфига");
        }
        config = new Config(0, 0, false);
    }

    private void saveConfig()
    {
        config.setTypeFilterIndex(typeFilterBox.getSelectedIndex());
        config.setCostFilterIndex(costFilterBox.getSelectedIndex());
        config.setCostSort(costSort);

        try {
            Files.writeString(configPath, gson.toJson(config));
        } catch (IOException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка сохранения конфига");
        }
    }
}

@Data
@AllArgsConstructor
class Config {
    private int typeFilterIndex;
    private int costFilterIndex;
    private boolean costSort;
}