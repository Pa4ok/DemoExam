package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.util.Date;

@Data //@EqualsAndHashCode @ToString @Getter @Setter
@AllArgsConstructor
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;
    private String type;

    public BookEntity(String title, String author, int pages, Date writeDateTime, String type) {
        this(-1, title, author, pages, writeDateTime, type);
    }
}
