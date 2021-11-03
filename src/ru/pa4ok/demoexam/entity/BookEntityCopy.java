package ru.pa4ok.demoexam.entity;

import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data //@ToString @Getter @Setter @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
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
