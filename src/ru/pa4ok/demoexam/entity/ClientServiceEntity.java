package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ClientServiceEntity
{
    private int id;
    private int clientId;
    private int serviceId;
    private String title;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String phone;
    private Date startDateTime;
}
