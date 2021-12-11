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

public class ClientEditForm extends BaseForm
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
    private JTextField idField;
    private JTextField regDateField;
    private JButton deleteButton;
    private JTextField imageField;

    private ClientEntity client;

    public ClientEditForm(ClientEntity client)
    {
        super(400, 375);
        this.client = client;
        setContentPane(mainPanel);

        initBoxes();
        initFields();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        genderBox.addItem("Женский");
        genderBox.addItem("Мужской");
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(client.getId()));
        firstnameField.setText(client.getFirstname());
        lastnameField.setText(client.getLastname());
        patronymicField.setText(client.getPatronymic());
        birthdayField.setText(Application.DATE_FORMAT.format(client.getBirthday()));
        regDateField.setText(Application.DATE_FORMAT.format(client.getRegDate()));
        emailField.setText(client.getEmail());
        phoneField.setText(client.getPhone());
        genderBox.setSelectedIndex(client.getGender() == 'ж' ? 0 : 1);
        imageField.setText(client.getPhotoPath());
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

            Date regDate = null;
            try {
                regDate = Application.DATE_FORMAT.parse(regDateField.getText());
            } catch (ParseException ex) {
                DialogUtil.showError(this, "Дата регистрации не введена или введена некорректно");
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

            client.setFirstname(firstname);
            client.setLastname(lastname);
            client.setPatronymic(patronymic);
            client.setRegDate(regDate);
            client.setBirthday(birthday);
            client.setEmail(email);
            client.setPhone(phone);
            client.setGender(gender);
            client.setPhotoPath(imagePath);

            try {
                ClientEntityManager.update(client);
            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения данных: " + ex.getMessage());
                return;
            }

            DialogUtil.showInfo(this, "Клиент успешно отредактирован");
            dispose();
            new ClientTableForm();
        });

        backButton.addActionListener(e -> {
            dispose();
            new ClientTableForm();
        });

        deleteButton.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(this, "Вы точно хотите удалить данную запись?", "Подтверждение", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
                try {
                    ClientEntityManager.delete(client);
                    DialogUtil.showInfo(this, "Клиент успешно удален");
                    dispose();
                    new ClientTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Ошибка удаления данных: " + ex.getMessage());
                }
            }
        });
    }
}
