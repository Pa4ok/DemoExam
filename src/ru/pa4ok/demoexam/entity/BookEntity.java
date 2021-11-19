package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data //@EqualsAndHashCode @ToString @Getter @Setter
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    public BookEntity(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }
}
