package ru.pa4ok.demoexam.entity;

import lombok.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Data
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;
    private String type;

    private ImageIcon image;

    public BookEntity(int id, String title, String author, int pages, Date writeDateTime, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.writeDateTime = writeDateTime;
        this.type = type;

        try {
            this.image = new ImageIcon(
                    ImageIO.read(BookEntity.class.getClassLoader().getResource("книги/book.jpg"))
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BookEntity(String title, String author, int pages, Date writeDateTime, String type) {
        this(-1, title, author, pages, writeDateTime, type);
    }
}
