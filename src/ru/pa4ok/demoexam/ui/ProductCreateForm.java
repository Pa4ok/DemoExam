package ru.pa4ok.demoexam.ui;

import ru.pa4ok.demoexam.entity.ProductEntity;
import ru.pa4ok.demoexam.manager.ProductEntityManager;
import ru.pa4ok.demoexam.util.BaseForm;
import ru.pa4ok.demoexam.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class ProductCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField typeField;
    private JTextField articleField;
    private JTextArea descField;
    private JTextField imageField;
    private JSpinner personCountSpinner;
    private JSpinner workstationNumberSpinner;
    private JTextField costForAgentField;
    private JButton backButton;
    private JButton saveButton;

    public ProductCreateForm()
    {
        super(400, 500);
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
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

            String article = articleField.getText();
            if(article.isEmpty() || article.length() > 10) {
                DialogUtil.showError(this, "Артикуль введен неверно");
                return;
            }

            String desc = descField.getText();

            String image = imageField.getText();
            if(image.length() > 100) {
                DialogUtil.showError(this, "Путь до картинки введен неверно");
                return;
            }

            int personCount = (int) personCountSpinner.getValue();
            if(personCount < 0) {
                DialogUtil.showError(this, "Количество человек для производства введно неверно");
                return;
            }

            int workshopNumber = (int) workstationNumberSpinner.getValue();
            if(workshopNumber < 0) {
                DialogUtil.showError(this, "Номер рабочей станции введн неверно");
                return;
            }

            double minCost = -1;
            try {
                minCost = Double.parseDouble(costForAgentField.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Стоимость введена неверно");
                return;
            }
            if(minCost < 0) {
                DialogUtil.showError(this, "Стоимость введена неверно");
                return;
            }

            ProductEntity product = new ProductEntity(-1, title, type, article, desc, image, personCount, workshopNumber, minCost);

            try {
                ProductEntityManager.insert(product);
                DialogUtil.showInfo(this, "Запись успешно добавлена");
                dispose();
                new ProductTableForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения данных");
            }
        });
    }
}
