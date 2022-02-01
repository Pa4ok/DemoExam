package ru.pa4ok.demoexam.test;

/**
 * ru.itmo.test.QuadraticEquation
 * - public double[] calculate(double a, double b, double c)
 * функция возвращает массив корней (длина 1/2) (если корней нет return null)
 * входные значения ограничены числами от -100 до 100 (если не подходит return null)
 *
 * реализовать функцию и 10 тестов к ней
 * библитека для тестов: org.junit.jupiter:junit-jupiter:5.4.2
 */
public class Calculation
{
    public static void main(String[] args)
    {
        Calculation calculation = new Calculation();
        System.out.println(calculation.getQuantityForProduct(3, 1, 15, 20, 45));
        System.out.println(calculation.getQuantityForProduct(3, 1, 15, 125.34F, 45.11F));
    }

    public int getQuantityForProduct(int productType, int materialType, int count, float width, float length)
    {
        double result = 1;

        switch (productType)
        {
            case 1:
                result *= 1.1;
                break;
            case 2:
                result *= 2.5;
                break;
            case 3:
                result *= 8.48;
                break;
            default:
                return -1;
        }

        switch (materialType)
        {
            case 1:
                result /= 99.7;
                result *= 100;
                break;
            case 2:
                result /= 99.88;
                result *= 100;
                break;
            default:
                return -1;
        }

        if(count < 0) {
            return -1;
        }
        result *= count;

        result *= width;
        result *= length;

        return (int)Math.ceil(result);
    }
}
