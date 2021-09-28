package ru.pa4ok.demoexam;

public abstract class Sortringer
{
    public abstract void sort(int[] arr);

    public long sortWithTime(int[] arr) {
        long startMills = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis() - startMills;
    }
}
