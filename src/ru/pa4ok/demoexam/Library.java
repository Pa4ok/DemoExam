package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private String address;
    private List<Book> books = new ArrayList<>();

    public Library(String address) {
        this.address = address;
    }

    public Book addBook(String title, String author, int pages)
    {
        if(hasBook(title, author)) {
            return null;
        }

        Book b = new Book(title, author, pages);
        books.add(b);
        return b;
    }

    public Book removeBook(String title, String author)
    {
        int k = -1;

        for(int i=0; i<books.size(); i++) {
            Book b = books.get(i);
            if(b.getTitle().equals(title) && b.getAuthor().equals(author)) {
                k = i;
                break;
            }
        }

        if(k != -1) {
            Book b = books.get(k);
            books.remove(k);
            return b;
        }
        return null;
    }

    public boolean hasBook(String title, String author)
    {
        for(int i=0; i<books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().equals(title) && b.getAuthor().equals(author)) {
                return true;
            }
        }
        return false;
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
