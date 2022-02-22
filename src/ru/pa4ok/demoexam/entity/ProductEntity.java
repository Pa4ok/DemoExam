package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Data
public class ProductEntity
{
    private int id;
    private String title;
    private String type;
    private String article;
    private String desc;
    private String image;
    private int personCount;
    private int workshopNumber;
    private double cost;

    private ImageIcon imageIcon;

    public ProductEntity(int id, String title, String type, String article, String desc, String image, int personCount, int workshopNumber, double cost) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.article = article;
        this.desc = desc;
        this.image = image.substring(1);
        this.personCount = personCount;
        this.workshopNumber = workshopNumber;
        this.cost = cost;

        try {
            this.imageIcon = new ImageIcon(ImageIO.read(ProductEntity.class.getClassLoader().getResource(this.image))
                    .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            try {
                this.imageIcon = new ImageIcon(ImageIO.read(ProductEntity.class.getClassLoader().getResource("picture.png"))
                        .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            } catch (Exception ex) {
            }
        }
    }
}
