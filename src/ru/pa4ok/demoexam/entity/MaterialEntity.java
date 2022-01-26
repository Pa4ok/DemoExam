package ru.pa4ok.demoexam.entity;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * класс-сущность описвающая материал
 */
@Data
public class MaterialEntity
{
    private int id;
    private String title;
    private String materialType;
    private String unit;
    private double cost;
    private int packCount;
    private int stockCount;
    private int minCount;
    private String desc;
    private String imagePath;

    private ImageIcon image;

    public MaterialEntity(int id, String title, String materialType, String unit, double cost, int packCount, int stockCount, int minCount, String desc, String imagePath) {
        this.id = id;
        this.title = title;
        this.materialType = materialType;
        this.unit = unit;
        this.cost = cost;
        this.packCount = packCount;
        this.stockCount = stockCount;
        this.minCount = minCount;
        this.desc = desc;
        this.imagePath = imagePath;

        try {
            this.image = new ImageIcon(ImageIO.read(MaterialEntity.class.getClassLoader().getResource(imagePath))
                    .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            try {
                this.image = new ImageIcon(ImageIO.read(MaterialEntity.class.getClassLoader().getResource("picture.png"))
                        .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            } catch (Exception e1) {
            }
        }
    }
}
