package ru.pa4ok.demoexam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Data
public class ServiceEntity
{
    private int id;
    private String title;
    private int duration;
    private double cost;
    private double discount;
    private String description;
    private String imagePath;

    private ImageIcon image;

    public ServiceEntity(int id, String title, int duration, double cost, double discount, String description, String imagePath) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.cost = cost;
        this.discount = discount;
        this.description = description;
        this.imagePath = imagePath;

        try {
            this.image = new ImageIcon(
                    ImageIO.read(ServiceEntity.class.getClassLoader().getResource(imagePath))
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)
            );
        } catch (Exception e) {
        }
    }

    public ServiceEntity(String title, int duration, double cost, double discount, String description, String imagePath) {
        this(-1, title, duration, cost, discount, description, imagePath);
    }
}
