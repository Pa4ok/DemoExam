package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

public class Library
{
    private String address;
    private Book[] books;

    public Library(String address, Book[] books) {
        this.address = address;
        this.books = books;
    }

    public void readBook() throws BookReadException, LibrarySpaceException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите название: ");
        String title = scanner.nextLine();
        if(title.length() < 3 || title.length() > 20) {
            throw new BookReadException("неверное название: " + title);
        }

        System.out.printf("Введите автора: ");
        String author = scanner.nextLine();
        if(author.length() < 3 || author.length() > 20) {
            throw new BookReadException("неверный автор: " + author);
        }

        System.out.printf("Введите количество страниц: ");
        String pagesString = scanner.nextLine();
        int pages = -1;
        try {
            pages = Integer.parseInt(pagesString);
        } catch (Exception e) {
            throw new BookReadException("неверное количество страниц", e);
        }
        if(pages <= 0) {
            throw new BookReadException("неверное количество страниц: " + pages);
        }

        Book b = new Book(title, author, pages);

        for(int i=0; i<books.length; i++) {
            if(books[i] == null) {
                books[i] = b;
                return;
            }
        }

        throw new LibrarySpaceException(b);
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
