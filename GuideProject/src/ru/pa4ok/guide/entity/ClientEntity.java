package ru.pa4ok.guide.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
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

    public ClientEntity(String firstname, String lastname, String patronymic, Date birthday, Date regDate, String email, String phone, char gender) {
        this(-1, firstname, lastname, patronymic, birthday, regDate, email, phone, gender);
    }
}
