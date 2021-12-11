package ru.pa4ok.table.entity;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

/*
  `ID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(50) CHARACTER SET 'utf8mb4' NOT NULL,
  `LastName` VARCHAR(50) CHARACTER SET 'utf8mb4' NOT NULL,
  `Patronymic` VARCHAR(50) CHARACTER SET 'utf8mb4' NULL,
  `Birthday` DATE NULL,
  `RegistrationDate` DATETIME(6) NOT NULL,
  `Email` VARCHAR(255) CHARACTER SET 'utf8mb4' NULL,
  `Phone` VARCHAR(20) CHARACTER SET 'utf8mb4' NOT NULL,
  `GenderCode` CHAR(1) CHARACTER SET 'utf8mb4' NOT NULL,
  `PhotoPath` VARCHAR(1000) CHARACTER SET 'utf8mb4' NULL,
 */
@Data
public class ClientEntity
{
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date birthday;
    private Date registerDate;
    private String email;
    private String phone;
    private String gender;
    private String photoPath;

    private ImageIcon image;

    public ClientEntity(int id, String firstName, String lastName, String patronymic, Date birthday, Date registerDate, String email, String phone, String gender, String photoPath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.registerDate = registerDate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.photoPath = photoPath;

        try {
            this.image = new ImageIcon(
                ImageIO.read(ClientEntity.class.getClassLoader().getResource(photoPath))
                        .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
        }
    }

    public ClientEntity(String firstName, String lastName, String patronymic, Date birthday, Date registerDate, String email, String phone, String gender, String photoPath) {
        this(-1, firstName, lastName, patronymic, birthday, registerDate, email, phone, gender, photoPath);
    }
}