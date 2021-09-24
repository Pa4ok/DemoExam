package ru.pa4ok.demoexam;

public class Book
{
    public static final String TEST_PARAM = "123321";
    public static final String TEST_PARAM_NEW;

    static {
        TEST_PARAM_NEW = "321123";
    }

    private final int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(String title) {
        this(-1, title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
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
