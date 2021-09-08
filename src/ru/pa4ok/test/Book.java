package ru.pa4ok.test;

public class Book
{
    /*
        public - видно везде
        private - только в рамках своего класса
        protected - ...
        default - в рамках 1 пакета
     */
    private String title;
    private String author;
    private int pages;

    //constructor(String,String,int)
    public Book(String title, String author, int pages)
    {
        if(title.startsWith("123")) {
            title = title.replace("123", "321");
        }

        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //constructor(String,String)
    /*public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.pages = 100;
    }*/

    public Book(String title, String author)
    {
        this(title, author, 100);
    }

    //переопределение вывода
    public String toString() {
        return "MyBook: " + this.title + " " + this.author + " " + this.pages;
    }

    public void testPublic() {
    }

    private void testPrivate() {
    }

    void testDefault() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        if(pages >= 0) {
            this.pages = pages;
        }
    }
}
