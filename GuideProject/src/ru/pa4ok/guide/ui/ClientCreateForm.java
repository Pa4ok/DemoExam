package ru.pa4ok.guide.ui;

import ru.pa4ok.guide.Application;
import ru.pa4ok.guide.entity.ClientEntity;
import ru.pa4ok.guide.manager.ClientEntityManager;
import ru.pa4ok.guide.util.BaseForm;
import ru.pa4ok.guide.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class ClientCreateForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JTextField emailField;
    private JTextField phoneField;
    private JComboBox<String> genderBox;
    private JButton saveButton;
    private JButton backButton;
    private JTextField imageField;

    public ClientCreateForm()
    {
        super(400, 375);
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        genderBox.addItem("Женский");
        genderBox.addItem("Мужской");
    }

    private void initButtons()
    {
        saveButton.addActionListener(e -> {
            String firstname = firstnameField.getText();
            if(firstname.isEmpty() || firstname.length() > 50) {
                DialogUtil.showError(this, "Имя не введено или слишком длинное");
                return;
            }

            String lastname = lastnameField.getText();
            if(lastname.isEmpty() || lastname.length() > 50) {
                DialogUtil.showError(this, "Фамилия не введена или слишком длинная");
                return;
            }

            String patronymic = patronymicField.getText();
            if(patronymic.isEmpty() || patronymic.length() > 50) {
                DialogUtil.showError(this, "Отчество не введено или слишком длинное");
                return;
            }

            Date birthday = null;
            try {
                birthday = Application.DATE_FORMAT.parse(birthdayField.getText());
            } catch (ParseException ex) {
                DialogUtil.showError(this, "День рождения не введен или введен некорректно");
                return;
            }

            String email = emailField.getText();
            if(email.isEmpty() || email.length() > 255) {
                DialogUtil.showError(this, "Email не введен или слишком длинный");
                return;
            }

            String phone = phoneField.getText();
            if(phone.isEmpty() || phone.length() > 20) {
                DialogUtil.showError(this, "Телефон не введен или слишком длинный");
                return;
            }

            char gender = genderBox.getSelectedIndex() == 0 ? 'ж' : 'м';

            String imagePath = imageField.getText();

            ClientEntity client = new ClientEntity(
                    firstname, lastname, patronymic,
                    birthday, new Date(),
                    email, phone,
                    gender,
                    imagePath
            );

            try {
                ClientEntityManager.insert(client);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                return;
            }

            DialogUtil.showInfo(this, "Клиент успешно добавлен");
            dispose();
            new ClientTableForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new ClientTableForm();
        });
    }
}
