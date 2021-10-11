package ru.pa4ok.demoexam;

import java.util.Set;

public class Library
{
    private String address;
    private Set<Book> books;

    public Library(String address, Set<Book> books) {
        this.address = address;
        this.books = books;
    }

    public Book addBook(String title, String author, int pages) {
        Book b = new Book(title, author, pages);
        return books.add(b) ? b : null;
    }

    public Book removeBook(String title, String author, int pages) {
        Book b = new Book(title, author, pages);
        return books.remove(b) ? b : null;
    }

    public boolean hasBook(String title, String author, int pages) {
        return books.contains(new Book(title, author, pages));
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

