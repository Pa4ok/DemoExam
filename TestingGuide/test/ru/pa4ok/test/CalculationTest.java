package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.testguide.Calculation;

public class CalculationTest
{
    private final Calculation calculation = new Calculation();

    @Test
    @DisplayName("Тестирование входящего типа продукции")
    public void test1()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10, 1, 1, 1, 1));
    }

    @Test
    @DisplayName("Тестирование входящего типа материала")
    public void test2()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(1, 10, 1, 1, 1));
    }

    @Test
    @DisplayName("Сложный тест на ширину материала")
    public void test3()
    {
        Assertions.assertEquals(111439, calculation.getQuantityForProduct(1, 1, 10, 154.44F, 65.4F));
    }
}
