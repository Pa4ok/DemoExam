package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.util.Date;

@Data //@EqualsAndHashCode @ToString @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntityCopy
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    public BookEntityCopy(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }
}
