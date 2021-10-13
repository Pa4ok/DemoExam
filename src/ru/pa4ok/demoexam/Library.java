package ru.pa4ok.demoexam;

import java.util.List;

public class Library
{
    private String address;
    private List<Book> books;

    public Library(String address, List<Book> books) {
        this.address = address;
        this.books = books;
    }

    public boolean hasBook(String title, String author, int pages)
    {
        for(Book b : books) {
            if(b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getPages() == pages) {
                return true;
            }
        }
        return false;
    }

    public Book addBook(String title, String author, int pages)
    {
        if(!hasBook(title, author, pages)) {
            Book b = new Book(title, author, pages);
            books.add(b);
            return b;
        }
        return null;
    }

    public Book removeBook(String title, String author, int pages)
    {
        for(int i=0; i<books.size(); i++) {
            Book b = books.get(i);
            if(b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getPages() == pages) {
                books.remove(i);
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", books=" + books +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
