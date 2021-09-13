package ru.pa4ok.demoexam;

import java.util.Arrays;

public class Library
{
    private String address;
    private Book[] books;

    public Library(String address, Book[] books) {
        this.address = address;
        this.books = books;
    }

    public void addBook(Book book)
    {
        for(int i=0; i<books.length; i++) {
            if(books[i] == null) {
                System.out.println("Книга " + book + " установлена на позицию " + i);
                books[i] = book;
                return;
            }
        }
        System.out.println("Книге " + book + " не хватило места");
    }

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
