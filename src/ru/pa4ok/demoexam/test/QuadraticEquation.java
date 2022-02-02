package ru.pa4ok.demoexam.test;

public class QuadraticEquation
{
    public double[] calculate(double a, double b, double c)
    {
        if(a < -100 || a > 100 || b < -100 || b > 100  || c < -100 || c > 100) {
            return null;
        }

        double d = Math.pow(b, 2) - 4 * a * c;

        if(d < 0) {
            return new double[0];
        }

        if(d == 0) {
            return new double[] { -b / (2 * a) };
        }

        double sqrtD = Math.sqrt(d);
        return new double[] {
                (-b + sqrtD) / (2 * a),
                (-b - sqrtD) / (2 * a)
        };
    }
}
