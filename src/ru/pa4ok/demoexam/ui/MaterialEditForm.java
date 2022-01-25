package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.MaterialEntity;
import ru.pa4ok.demoexam.manager.MaterialEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MaterialEditForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField typeField;
    private JTextField unitField;
    private JSpinner packSpinner;
    private JSpinner stockSpinner;
    private JSpinner minSpinner;
    private JTextField costField;
    private JTextArea descField;
    private JTextField imageField;
    private JButton backButton;
    private JButton saveButton;
    private JTextField idField;
    private JButton deleteButton;

    private MaterialEntity material;

    public MaterialEditForm(MaterialEntity material)
    {
        super(500, 400);
        this.material = material;
        setContentPane(mainPanel);

        initFields();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setText(String.valueOf(material.getId()));
        titleField.setText(material.getTitle());
        typeField.setText(material.getType());
        unitField.setText(material.getUnit());
        packSpinner.setValue(material.getCountInPack());
        stockSpinner.setValue(material.getCountInStock());
        minSpinner.setValue(material.getMinCount());
        costField.setText(String.valueOf(material.getCost()));
        descField.setText(material.getDesc());
        imageField.setText(material.getImage());
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

            int minCount = (int) minSpinner.getValue();
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
            }

            String desc = descField.getText();

            String image = imageField.getText();
            if(image.isEmpty() || image.length() > 100) {
                DialogUtil.showError(this, "Путь до картинки введен неверно");
                return;
            }

            material.setTitle(title);
            material.setType(type);
            material.setUnit(unit);
            material.setCountInPack(packCount);
            material.setCountInStock(stockCount);
            material.setMinCount(minCount);
            material.setCost(cost);
            material.setDesc(desc);
            material.setImage(image);

            try {
                MaterialEntityManager.update(material);
                DialogUtil.showInfo(this, "Запись успешно отредактирована");
                dispose();
                new MaterialTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
            }
        });

        deleteButton.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(
                    this,
                    "Вы точно хотите удалить данную запись?",
                    "Подтверждение",
                    JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                try {
                    MaterialEntityManager.delete(material);
                    DialogUtil.showInfo(this, "Запись успешно удалена");
                    dispose();
                    new MaterialTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });
    }
}
