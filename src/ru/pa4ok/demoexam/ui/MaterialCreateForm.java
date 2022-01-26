package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MaterialCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField typeField;
    private JTextField unitField;
    private JTextField costField;
    private JSpinner packSpinner;
    private JSpinner stockSpinner;
    private JSpinner minCountSpinner;
    private JTextArea descField;
    private JTextField imageField;
    private JButton backButton;
    private JButton saveButton;

    public MaterialCreateForm()
    {
        super(500, 425);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new MaterialTableForm();
        });

        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 100) {
                DialogUtil.showError(this, "Название введено неверно");
                return;
            }

            String type = typeField.getText();
            if(type.isEmpty() || type.length() > 100) {
                DialogUtil.showError(this, "Тип введен неверно");
                return;
            }

            String unit = unitField.getText();
            if(unit.isEmpty() || unit.length() > 10) {
                DialogUtil.showError(this, "Ед.изм. введена неверно");
                return;
            }

            int packCount = (int) packSpinner.getValue();
            if(packCount < 0) {
                DialogUtil.showError(this, "Кол-во в упаковке введено неверно");
                return;
            }

            int stockCount = (int) stockSpinner.getValue();
            if(stockCount < 0) {
                DialogUtil.showError(this, "Кол-во на складе введено неверно");
                return;
            }

            int minCount = (int) minCountSpinner.getValue();
            if(minCount < 0) {
                DialogUtil.showError(this, "Минимальное кол-во введено неверно");
                return;
            }

            double cost = 0;
            try {
                cost = Double.parseDouble(costField.getText());
                if(cost < 0) {
                    throw new RuntimeException();
                }
            } catch (Exception ex) {
                DialogUtil.showError(this, "Стоимость введена неверно");
                return;
            }

            String desc = descField.getText();

            String image = imageField.getText();
            if(image.length() > 100) {
                DialogUtil.showError(this, "Путь до картинки введен неверно");
                return;
            }

            MaterialEntity material = new MaterialEntity(
                    -1, title, type, unit,
                    cost, packCount, stockCount, minCount,
                    desc, image
            );

            try {
                MaterialEntityManager.insert(material);
                DialogUtil.showInfo(this, "Сущность успешно добавлена");
                dispose();
                new MaterialTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохрнения данных: " + ex.getMessage());
            }
        });
    }
}
