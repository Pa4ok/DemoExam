package ru.pa4ok.demoexam;

import java.util.*;

public class Library
{
    private String address;
    private Set<Book> books = new HashSet<>();
    private Map<Integer, Book> bookIdCache = new HashMap<>();

    public Library(String address) {
        this.address = address;
    }

    public boolean addBook(Book book) {
        if(!bookIdCache.containsKey(book.getId())) {
            books.add(book);
            bookIdCache.put(book.getId(), book);
            return true;
        }
        return false;
    }

    public boolean hasBook(Book book)
    {
        return bookIdCache.containsKey(book.getId());
    }

    public boolean removeBook(Book book)
    {
        if(bookIdCache.remove(book.getId()) != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public Book addBook(int id, String title, String author, int pages)
    {
        if(!bookIdCache.containsKey(id)) {
            Book book = new Book(id, title, author, pages);
            books.add(book);
            bookIdCache.put(id, book);
            return book;
        }
        return null;
    }

    public Book hasBook(int bookId)
    {
        return bookIdCache.get(bookId);
    }

    public Book removeBook(int bookId)
    {
        Book book = bookIdCache.remove(bookId);
        if(book != null) {
            books.remove(book);
        }
        return book;
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", books=" + books +
                ", bookIdCache=" + bookIdCache +
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

    public Map<Integer, Book> getBookIdCache() {
        return bookIdCache;
    }

    public void setBookIdCache(Map<Integer, Book> bookIdCache) {
        this.bookIdCache = bookIdCache;
    }
}
