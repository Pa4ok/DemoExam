package ru.pa4ok.demoexam;

public class LibrarySpaceException extends Exception
{
    private Book book;

    public LibrarySpaceException(Book book) {
        this.book = book;
    }

    public LibrarySpaceException(String message, Book book) {
        super(message);
        this.book = book;
    }

    public LibrarySpaceException(String message, Throwable cause, Book book) {
        super(message, cause);
        this.book = book;
    }

    public LibrarySpaceException(Throwable cause, Book book) {
        super(cause);
        this.book = book;
    }

    public LibrarySpaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Book book) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
