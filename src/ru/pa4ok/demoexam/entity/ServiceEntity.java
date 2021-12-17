package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceEntity
{
    private int id;
    private String title;
    private int duration;
    private double cost;
    private double discount;
    private String desc;
    private String imagePath;
}
