package ru.pa4ok.demoexam;

import java.util.Arrays;

public class Library
{
    private String address;
    private Book[] books;

    public Library(String address, Book[] books)
    {
        this.address = address;
        this.books = books;
    }

    public void addBook(Book book)
    {
        for(int i=0; i<this.books.length; i++) {
            if(this.books[i] == null) {
                this.books[i] = book;
                System.out.println("Книга " + book + " сохранена на позицию " + i);
                return;
            }
        }
        System.out.println("Книге " + book + " не хватило места");
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
