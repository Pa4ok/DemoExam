package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ServiceEntity;
import ru.pa4ok.demoexam.manager.ServiceEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class ServiceCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JSpinner durationSpinner;
    private JTextField costField;
    private JTextField discountField;
    private JTextField descField;
    private JTextField imagePathField;
    private JButton backButton;
    private JButton saveButton;

    public ServiceCreateForm()
    {
        super(425, 375);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ServiceTableForm();
        });

        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if(title.isEmpty() || title.length() > 100) {
                DialogUtil.showError(this, "Название не введено или слишком длинное");
                return;
            }

            int duration = (int) durationSpinner.getValue();
            if(duration < 0) {
                DialogUtil.showError(this, "Длительность введена неверно");
                return;
            }

            double cost = -1;
            try {
                cost = Double.parseDouble(costField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Стоимость введена неверно");
                return;
            }
            if(cost < 0) {
                DialogUtil.showError(this, "Стоимость введена неверно");
                return;
            }

            double discount = -1;
            try {
                discount = Double.parseDouble(discountField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Скидка введена неверно");
                return;
            }
            if(discount < 0) {
                DialogUtil.showError(this, "Скидка введена неверно");
                return;
            }

            String desc = descField.getText();

            String imagePath = imagePathField.getText();
            if(imagePath.length() > 1000) {
                DialogUtil.showError(this, "Путь до картинки слишком длинный");
                return;
            }

            ServiceEntity service = new ServiceEntity(
                    title,
                    duration,
                    cost,
                    discount,
                    desc,
                    imagePath
            );

            try {
                ServiceEntityManager.insert(service);
                DialogUtil.showInfo(this, "Запись успешно добавлена");
                dispose();
                new ServiceTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка добавления данных: " + ex.getMessage());
            }
        });
    }
}
