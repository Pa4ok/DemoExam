package ru.pa4ok.demoexam.test;

public class Calculation
{
    public static void main(String[] args)
    {
        Calculation calculation = new Calculation();
        System.out.println(calculation.getQuantityForProduct(3, 1, 15, 20, 45));
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
                result *= 8.43;
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

        if(count < 0 || length <= 0 || width <= 0) {
            return -1;
        }
        result = result * count * length * width;

        return (int) Math.ceil(result);
    }
}
