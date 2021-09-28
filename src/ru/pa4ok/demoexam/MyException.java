package ru.pa4ok.demoexam;

public class MyException extends Exception
{
    private boolean test;

    public MyException(boolean test) {
        this.test = test;
    }

    public MyException(String message, boolean test) {
        super(message);
        this.test = test;
    }

    public MyException(String message, Throwable cause, boolean test) {
        super(message, cause);
        this.test = test;
    }

    public MyException(Throwable cause, boolean test) {
        super(cause);
        this.test = test;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, boolean test) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.test = test;
    }
}
