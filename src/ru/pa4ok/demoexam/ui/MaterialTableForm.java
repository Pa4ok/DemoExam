package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.CustomTableModel;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.SQLException;

public class MaterialTableForm extends BaseForm
{
    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel<MaterialEntity> model;

    public MaterialTableForm()
    {
        super(1200, 800);
        setContentPane(mainPanel);

        initTable();

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

        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError(this, "Ошибка получения данных: " + e.getMessage());
        }
    }
}
