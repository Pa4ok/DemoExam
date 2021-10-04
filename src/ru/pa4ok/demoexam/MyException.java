package ru.pa4ok.demoexam;

public class MyException extends Exception
{
    public int value;

    public MyException(int value) {
        this.value = value;
    }

    public MyException(String message, int value) {
        super(message);
        this.value = value;
    }

    public MyException(String message, Throwable cause, int value) {
        super(message, cause);
        this.value = value;
    }

    public MyException(Throwable cause, int value) {
        super(cause);
        this.value = value;
    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int value) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.value = value;
    }
}
