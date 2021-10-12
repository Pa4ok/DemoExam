package ru.pa4ok.demoexam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library
{
    private String address;
    private Set<Book> books = new HashSet<>();
    private Map<Integer, Book> bookIdCache = new HashMap<>();

    public Library(String address) {
        this.address = address;
    }

    public boolean addBook(Book book) {
        if(books.add(book)) {
            bookIdCache.put(book.getId(), book);
            return true;
        }
        return false;
    }

    public boolean hasBook(Book book) {
        return books.contains(book);
    }

    public boolean removeBook(Book book) {
        if(books.remove(book)) {
            bookIdCache.remove(book.getId());
            return true;
        }
        return false;
    }

    public Book addBook(int id, String title, String author, int pages) {
        if(!bookIdCache.containsKey(id)) {
            Book book = new Book(id, title, author, pages);
            books.add(book);
            bookIdCache.put(id, book);
            return book;
        }
        return null;
    }

    public Book hasBook(int bookId) {
        return bookIdCache.get(bookId);
    }

    public Book removeBook(int bookId) {
        Book book = bookIdCache.remove(bookId);
        if(book != null) {
            books.remove(book);
        }
        return book;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", books=" + books +
                ", bookIdCache=" + bookIdCache +
                '}';
    }
}

