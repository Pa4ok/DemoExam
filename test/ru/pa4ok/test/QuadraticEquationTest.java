package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.demoexam.test.QuadraticEquation;

public class QuadraticEquationTest
{
    private QuadraticEquation equation = new QuadraticEquation();

    @Test
    @DisplayName("Тест 1")
    public void test1()
    {
        Assertions.assertArrayEquals(new double[] { 7, -8 }, equation.calculate(1, 1, -56));
    }

    @Test
    @DisplayName("Тест 2")
    public void test2()
    {
        Assertions.assertNull(equation.calculate(1000, 1, -56));
    }
}
