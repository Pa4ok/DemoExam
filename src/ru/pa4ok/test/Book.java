package ru.pa4ok.test;

public class Book
{
    /*
        public - видно везде
        private - только из этого же класса
        protected - позже при наследовании посмотрим
        default - в рамках одного пакета
     */

    private String title;
    private int pages;

    public Book(String title, int pagesIn)
    {
        this.title = title;
        pages = pagesIn;
    }

    public void print()
    {
        System.out.println("MyBook: " + title + " " + this.pages);
    }

    public void test1() {
    }

    private void test2() {
    }

    void test3() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        if(pages > 0) {
            this.pages = pages;
        }
    }
}
