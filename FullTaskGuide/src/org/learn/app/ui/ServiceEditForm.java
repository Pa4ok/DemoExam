package org.learn.app.ui;

import org.learn.app.entity.ServiceEntity;
import org.learn.app.manager.ServiceEntityManager;
import org.learn.app.ui.ServiceTableForm;
import org.learn.app.util.BaseForm;
import org.learn.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

/**
 * форма редактироваия услуги
 */
public class ServiceEditForm extends BaseForm
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
    private JButton deleteButton;
    private JTextField idField;

    private ServiceEntity service;

    public ServiceEditForm(ServiceEntity service)
    {
        super(425, 375);
        this.service = service;
        setContentPane(mainPanel);

        initFields();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(service.getId()));
        titleField.setText(service.getTitle());
        durationSpinner.setValue(service.getDuration());
        costField.setText(String.valueOf(service.getCost()));
        discountField.setText(String.valueOf(service.getDiscount()));
        descField.setText(service.getDesc());
        imagePathField.setText(service.getImagePath());
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
                DialogUtil.showError(this, "Стоимость введена не верно");
                return;
            }
            if(cost < 0) {
                DialogUtil.showError(this, "Стоимость введена не верно");
                return;
            }

            double discount = -1;
            try {
                discount = Double.parseDouble(discountField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Скидка введена не верно");
                return;
            }
            if(discount < 0 || discount > 100) {
                DialogUtil.showError(this, "Скидка введена не верно");
                return;
            }

            String desc = descField.getText();

            String imagePath = imagePathField.getText();
            if(imagePath.length() > 1000) {
                DialogUtil.showError(this, "Путь до картинки слишком длинный");
                return;
            }

            service.setTitle(title);
            service.setDuration(duration);
            service.setCost(cost);
            service.setDiscount(discount);
            service.setDesc(desc);
            service.setImagePath(imagePath);

            try {
                ServiceEntityManager.update(service);
                DialogUtil.showInfo(this, "Запись успешно отредактирована");
                dispose();
                new ServiceTableForm();
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
                    ServiceEntityManager.delete(service);
                    DialogUtil.showInfo(this, "Запись успешно удалена");
                    dispose();
                    new ServiceTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });
    }
}
