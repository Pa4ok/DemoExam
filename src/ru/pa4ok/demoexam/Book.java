package ru.pa4ok.demoexam;

public class Book
{
    private static int idCounter = 0;

    private final int id;
    private String title;
    private String test1;
    private String test2;
    private String test3;

    public Book(String title) {
        this.id = ++idCounter;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", test1='" + test1 + '\'' +
                ", test2='" + test2 + '\'' +
                ", test3='" + test3 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
