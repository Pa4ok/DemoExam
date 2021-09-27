package ru.pa4ok.demoexam;

import java.util.Arrays;

public class Figure
{
    protected String title;
    protected Point[] points;

    public Figure(String title, Point[] points) {
        this.title = title;
        this.points = points;
    }

    public double calculateSquare() {
        return -1D;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "title='" + title + '\'' +
                ", points=" + Arrays.toString(points) +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
