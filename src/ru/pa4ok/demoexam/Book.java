package ru.pa4ok.demoexam;

public class Book
{
    private String title;
    private int pages;

    public Book(String title, int pages)
    {
        this.title = title;
        this.pages = pages;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
