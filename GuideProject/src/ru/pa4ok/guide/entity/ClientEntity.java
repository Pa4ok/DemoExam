package ru.pa4ok.guide.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

@Data
public class ClientEntity
{
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Date birthday;
    private Date regDate;
    private String email;
    private String phone;
    private char gender;
    private String photoPath;

    private ImageIcon image;

    public ClientEntity(int id, String firstname, String lastname, String patronymic, Date birthday, Date regDate, String email, String phone, char gender, String photoPath) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.regDate = regDate;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.photoPath = photoPath;

        try {
            this.image = new ImageIcon(
                    ImageIO.read(ClientEntity.class.getClassLoader().getResource(photoPath))
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)
            );
        } catch (Exception e) {
        }
    }

    public ClientEntity(String firstname, String lastname, String patronymic, Date birthday, Date regDate, String email, String phone, char gender, String photoPath) {
        this(-1, firstname, lastname, patronymic, birthday, regDate, email, phone, gender, photoPath);
    }
}
