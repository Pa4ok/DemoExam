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
        BookEntity book = (BookEntity) o;
        return id == book.id && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(writeDateTime, book.writeDateTime);
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

    public BookEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public BookEntity setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Date getWriteDateTime() {
        return writeDateTime;
    }

    public BookEntity setWriteDateTime(Date writeDateTime) {
        this.writeDateTime = writeDateTime;
        return this;
    }
}
