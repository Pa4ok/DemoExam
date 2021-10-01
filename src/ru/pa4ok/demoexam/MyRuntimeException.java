package ru.pa4ok.demoexam;

public class MyRuntimeException extends RuntimeException
{
    public int value;

    public MyRuntimeException(int value) {
        this.value = value;
    }

    public MyRuntimeException(String message, int value) {
        super(message);
        this.value = value;
    }

    public MyRuntimeException(String message, Throwable cause, int value) {
        super(message, cause);
        this.value = value;
    }

    public MyRuntimeException(Throwable cause, int value) {
        super(cause);
        this.value = value;
    }

    public MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int value) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.value = value;
    }
}
