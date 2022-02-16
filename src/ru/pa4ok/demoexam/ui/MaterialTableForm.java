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
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

public class MaterialTableForm extends BaseForm
{
    private Path configPath = Paths.get("config.txt");
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Config config;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton costSortButton;
    private JComboBox typeFilterBox;
    private JComboBox costFilterBox;
    private JButton clearButton;
    private JLabel rowCountLabel;
    private JButton helpButton;
    private JButton dealButton;
    private JButton exportButton;

    private boolean costSort;

    private CustomTableModel<MaterialEntity> model;

    public MaterialTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();
        loadConfig();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        try {
            model = new CustomTableModel<>(
                    MaterialEntity.class,
                    new String[] {
                            "ID", "Наименование", "Тип материала", "Ед.изм.",
                            "Стоимость", "Кол-во в упаковке", "Кол-во на складе", "Мин. кол-во",
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
            if(model.getRowCount() == 0) {
                DialogUtil.showInfo(this, "В бд не найдено ни 1 записи");
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
                        new MaterialEditForm(model.getRows().get(row));
                    }
                }
            }
        });
    }

    private void initBoxes()
    {
        try {
            List<MaterialEntity> list = MaterialEntityManager.selectAll();
            Set<String> types = new HashSet<>();
            for(MaterialEntity m : list) {
                types.add(m.getMaterialType());
            }
            typeFilterBox.addItem("Все типы");
            for(String s : types) {
                typeFilterBox.addItem(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }

        costFilterBox.addItem("Все");
        costFilterBox.addItem("До 5к");
        costFilterBox.addItem("От 5к до 15к");
        costFilterBox.addItem("От 15к до 50к");
        costFilterBox.addItem("От 50к до 100к");
        costFilterBox.addItem("Больше 100к");

        typeFilterBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
                saveConfig();
            }
        });

        costFilterBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                applyFilters();
                saveConfig();
            }
        });
    }

    private void applyFilters()
    {
        try {
            List<MaterialEntity> all = MaterialEntityManager.selectAll();
            int max = all.size();

            if(typeFilterBox.getSelectedIndex() != 0) {
                all.removeIf(material -> !material.getMaterialType().equals(typeFilterBox.getSelectedItem()));
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
                DialogUtil.showInfo(this, "В бд найдено ни 1 записи после применения фильтров");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных");
        }
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            dispose();
            new MaterialCreateForm();
        });

        costSortButton.addActionListener(e -> {
            applyCostSort();
            saveConfig();
        });

        clearButton.addActionListener(e -> {
            typeFilterBox.setSelectedIndex(0);
            costFilterBox.setSelectedIndex(0);
        });

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование - двойной клик по запили\nУдаление - внутри формы редактирования");
        });

        dealButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связь с разработчиком: vasya_2008@mail.ru");
        });

        exportButton.addActionListener(e -> {
            List<String> lines = new ArrayList<>();
            for(MaterialEntity m : model.getRows()) {
                lines.add(m.toString());
            }
            try {
                Files.write(Paths.get("content.txt"), lines);
                DialogUtil.showInfo(this, "Данные успешно экспортированы");
            } catch (IOException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка экспорта данных: " + ex.getMessage());
            }
        });
    }

    private void applyCostSort()
    {
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
    }

    private void updateRowCountLabel(int actual, int max)
    {
        rowCountLabel.setText("Записей: " + actual + " / " + max);
    }

    private boolean blockSave = false;

    private void saveConfig()
    {
        if(!blockSave) {
            config.setTypeFilterIndex(typeFilterBox.getSelectedIndex());
            config.setCostFilterIndex(costFilterBox.getSelectedIndex());
            config.setCostSort(costSort);

            try {
                Files.writeString(configPath, gson.toJson(config));
            } catch (IOException e) {
                e.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения конфига: " + e.getMessage());
            }
        }
    }

    private void loadConfig()
    {
        try {
            if(Files.exists(configPath)) {
                blockSave = true;
                config = gson.fromJson(Files.readString(configPath), Config.class);
                typeFilterBox.setSelectedIndex(config.getTypeFilterIndex());
                costFilterBox.setSelectedIndex(config.getCostFilterIndex());
                if(config.isCostSort()) {
                    applyCostSort();
                }
                blockSave = false;
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        config = new Config(0, 0, false);
    }
}

@Data
@AllArgsConstructor
class Config
{
    private int typeFilterIndex;
    private int costFilterIndex;
    private boolean costSort;
}