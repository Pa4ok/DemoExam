package ru.pa4ok.demoexam;

public class Triangle extends Figure
{
    public Triangle(Point a, Point b, Point c)
    {
        super("Треугольник", new Point[]{a, b, c});
    }

    @Override
    public double calculateSquare()
    {
        return 0.5 * Math.abs((points[1].getX() - points[0].getX()) * (points[2].getY() - points[0].getY())
                - (points[2].getX() - points[0].getX()) * (points[1].getY() - points[0].getY()));
    }
}
