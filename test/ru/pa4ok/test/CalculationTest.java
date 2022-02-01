package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.demoexam.test.Calculation;

public class CalculationTest
{
    private Calculation calculation = new Calculation();

    @Test
    @DisplayName("Простой тест 1")
    public void test1()
    {
        Assertions.assertEquals(114148, calculation.getQuantityForProduct(3, 1, 15, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 2 на некоректное значение")
    public void test2()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10, 1, 15, 20, 45));
    }

    @Test
    @DisplayName("Сложный тест 1 с дробными числами")
    public void test3()
    {
        Assertions.assertEquals(115831, calculation.getQuantityForProduct(3, 1, 15, 20.228F, 45.1487F));
    }
}
