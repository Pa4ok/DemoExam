package ru.pa4ok.demoexam.entity;

import lombok.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Data //@EqualsAndHashCode @ToString @ToString @Getter @Setter
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    private Boolean testBoolean = new Random().nextBoolean();
    private ImageIcon image;

    public BookEntity(int id, String title, String author, int pages, Date writeDateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.writeDateTime = writeDateTime;

        try {
            this.image = new ImageIcon(ImageIO.read(BookEntity.class.getClassLoader().getResource("книги/image.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BookEntity(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }
}
