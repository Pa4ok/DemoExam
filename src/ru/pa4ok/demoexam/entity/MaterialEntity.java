package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

@Data
public class MaterialEntity
{
    private int id;
    private String title;
    private String type;
    private String unit;
    private int countInPack;
    private int countInStock;
    private int minCount;
    private double cost;
    private String desc;
    private String image;

    private ImageIcon imageIcon;

    public MaterialEntity(int id, String title, String type, String unit, int countInPack, int countInStock, int minCount, double cost, String desc, String image)
    {
        this.id = id;
        this.title = title;
        this.type = type;
        this.unit = unit;
        this.countInPack = countInPack;
        this.countInStock = countInStock;
        this.minCount = minCount;
        this.cost = cost;
        this.desc = desc;
        this.image = image;

        try {
            imageIcon = new ImageIcon(ImageIO.read(MaterialEntity.class.getClassLoader().getResource(image))
                    .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            try {
                imageIcon = new ImageIcon(ImageIO.read(MaterialEntity.class.getClassLoader().getResource("picture.png"))
                        .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
