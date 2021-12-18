package org.learn.app.entity;

import lombok.Data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

@Data
public class ServiceEntity
{
    private int id;
    private String title;
    private int duration;
    private double cost;
    private double discount;
    private String desc;
    private String imagePath;

    private ImageIcon image;

    public ServiceEntity(int id, String title, int duration, double cost, double discount, String desc, String imagePath) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.cost = cost;
        this.discount = discount;
        this.desc = desc;
        this.imagePath = imagePath.replaceAll(Pattern.quote("\\"), "/");

        try {
            this.image = new ImageIcon(
                    ImageIO.read(ServiceEntity.class.getClassLoader().getResource(this.imagePath))
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)
            );
        } catch (Exception e) {
        }
    }

    public ServiceEntity(String title, int duration, double cost, double discount, String desc, String imagePath) {
        this(-1, title, duration, cost, discount, desc, imagePath);
    }
}
