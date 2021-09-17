package ru.pa4ok.demoexam;

public class EquationUtil
{
    public static double[] solveQuadraticEquation(double a, double b, double c)
    {
        double d = Math.pow(b, 2) - 4 * a * c;

        if(d < 0) {
            return new double[0];
        }

        if(d == 0) {
            return new double[] {
                    -b / (2 * a)
            };
        }

        return new double[] {
                (-b + Math.sqrt(d)) / (2 * a),
                (-b - Math.sqrt(d)) / (2 * a)
        };
    }

    public static double[] solveQuadraticEquation(double a, double b)
    {
        return solveQuadraticEquation(a, b, 0);
    }
}
