package ru.pa4ok.testguide;

public class Calculation
{
    public static void main(String[] args)
    {
        Calculation calculation = new Calculation();
        System.out.println(calculation.getQuantityForProduct(3, 1, 15, 20, 45));
    }

    public int getQuantityForProduct(int productType, int materialType, int count, float width, float length)
    {
        double d = 1;

        switch (productType)
        {
            case 1:
                d *= 1.1;
                break;
            case 2:
                d *= 2.5;
                break;
            case 3:
                d *= 8.43;
                break;
            default:
                return -1;
        }

        switch (materialType)
        {
            case 1:
                d /= 99.7;
                d *= 100;
                break;
            case 2:
                d /= 99.88;
                d *= 100;
                break;
            default:
                return -1;
        }

        if(count < 0 || width <= 0 || length <= 0) {
            return -1;
        }

        d *= count;
        d *= width;
        d *= length;

        return (int) Math.ceil(d);
    }
}
