package org.learn.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
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

    private long daysAfter;

    public ClientServiceEntity(int id, int clientId, int serviceId, String title, String firstname, String lastname, String patronymic, String email, String phone, Date startDateTime) {
        this.id = id;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.startDateTime = startDateTime;

        long mills = new Date().getTime() - startDateTime.getTime();
        this.daysAfter = TimeUnit.DAYS.convert(mills, TimeUnit.MILLISECONDS);
    }
}
