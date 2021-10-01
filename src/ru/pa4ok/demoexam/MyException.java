package ru.pa4ok.demoexam;

public class MyException extends Exception
{
    public int i;

    public MyException(int i) {
        this.i = i;
    }

    public MyException(String message, int i) {
        super(message);
        this.i = i;
    }

    public MyException(String message, Throwable cause, int i) {
        super(message, cause);
        this.i = i;
    }

    public MyException(Throwable cause, int i) {
        super(cause);
        this.i = i;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int i) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.i = i;
    }
}
