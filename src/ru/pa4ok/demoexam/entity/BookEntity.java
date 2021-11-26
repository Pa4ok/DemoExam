package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data //@EqualsAndHashCode @ToString @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity
{
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    public BookEntity(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }
}
