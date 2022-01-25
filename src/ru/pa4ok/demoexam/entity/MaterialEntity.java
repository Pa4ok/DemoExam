package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaterialEntity
{
    private int id;
    private String title;
    private int countInPack;
    private String unit;
    private double countInStock;
    private double minCount;
    private String desc;
    private double cost;
    private String image;
    private String materialType;
}
