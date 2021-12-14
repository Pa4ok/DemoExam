package ru.pa4ok.demoexam.entity;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

@Data
public class ServiceEntity
{
    private int id;
    private String title;
    private int duration;
    private double cost;
    private double discount;
    private String imagePath;
    private String desc;

    private ImageIcon image;

    public ServiceEntity(int id, String title, int duration, double cost, double discount, String imagePath, String desc) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.cost = cost;
        this.discount = discount;
        this.imagePath = imagePath;
        this.desc = desc;

        try {
            this.image = new ImageIcon(
                    ImageIO.read(ServiceEntity.class.getClassLoader().getResource(imagePath))
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)
            );
        } catch (Exception e) {
        }
    }

    public ServiceEntity(String title, int duration, double cost, double discount, String imagePath, String desc) {
        this(-1, title, duration, cost, discount, imagePath, desc);
    }
}
