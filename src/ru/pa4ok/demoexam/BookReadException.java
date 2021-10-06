package ru.pa4ok.demoexam;

public class BookReadException extends Exception
{
    public BookReadException() {
    }

    public BookReadException(String message) {
        super(message);
    }

    public BookReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookReadException(Throwable cause) {
        super(cause);
    }

    public BookReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
