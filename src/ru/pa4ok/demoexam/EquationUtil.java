package ru.pa4ok.demoexam;

public class EquationUtil
{
    public static double[] solveQuadraticEquation(double a, double b, double c)
    {
        double d = b * b - 4 * a * c;

        if(d < 0) {
            return new double[0];
        }

        if(d == 0) {
            return new double[] {
                (-1 * b) / (2 * a)
            };
        }

        return new double[] {
                (-1 * b + Math.sqrt(d)) / (2 * a),
                (-1 * b - Math.sqrt(d)) / (2 * a)
        };
    }
}
