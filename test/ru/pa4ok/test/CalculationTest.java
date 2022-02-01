package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.demoexam.test.Calculation;

public class CalculationTest
{
    private Calculation calculation = new Calculation();

    @Test
    @DisplayName("Правильный тест 1")
    public void test1()
    {
        int result = calculation.getQuantityForProduct(3, 1, 15, 20, 45);
        Assertions.assertEquals(114148, result);
    }

    @Test
    @DisplayName("Неправильный тест 2")
    public void test2()
    {
        int result = calculation.getQuantityForProduct(10, 1, 15, 20, 45);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("Сложный тест 3")
    public void test3()
    {
        int result = calculation.getQuantityForProduct(3, 1, 15, 125.34F, 45.11F);
        Assertions.assertEquals(717111, result);
    }
}
