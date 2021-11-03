package ru.pa4ok.demoexam.entity;

import java.util.Date;
import java.util.Objects;

public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private int pages;
    private Date writeDateTime;

    public BookEntity(int id, String title, String author, int pages, Date writeDateTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.writeDateTime = writeDateTime;
    }

    public BookEntity(String title, String author, int pages, Date writeDateTime) {
        this(-1, title, author, pages, writeDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id && pages == that.pages && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(writeDateTime, that.writeDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, pages, writeDateTime);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", writeDateTime=" + writeDateTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getWriteDateTime() {
        return writeDateTime;
    }

    public void setWriteDateTime(Date writeDateTime) {
        this.writeDateTime = writeDateTime;
    }
}
