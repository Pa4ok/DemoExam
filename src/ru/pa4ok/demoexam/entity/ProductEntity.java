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
    private String description;
    private String image;
    private int personCount;
    private int workshopNumber;
    private double minCost;

    private ImageIcon imageIcon;

    public ProductEntity(int id, String title, String type, String article, String description, String image, int personCount, int workshopNumber, double minCost) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.article = article;
        this.description = description;
        this.image = image;
        this.personCount = personCount;
        this.workshopNumber = workshopNumber;
        this.minCost = minCost;

        try {
            this.imageIcon = new ImageIcon(ImageIO.read(ProductEntity.class.getClassLoader().getResource(image))
                    .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        } catch (Exception e) {
            try {
                this.imageIcon = new ImageIcon(ImageIO.read(ProductEntity.class.getClassLoader().getResource("picture.png"))
                        .getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            } catch (Exception e1) {
            }
        }
    }
}
