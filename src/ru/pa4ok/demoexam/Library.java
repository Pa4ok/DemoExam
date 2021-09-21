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

    public Library(String address, int length) {
        this(address, new Book[length]);
    }

    public Library(String address) {
        this(address, 10);
    }

    public void addBook(Book b) {
        for(int i=0; i<books.length; i++) {
            if(books[i] == null) {
                books[i] = b;
                System.out.println("Книга " + b + " поставлена на позицию " + i);
                return;
            }
        }
        System.out.println("Книге " + b + " не хватило места");
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
