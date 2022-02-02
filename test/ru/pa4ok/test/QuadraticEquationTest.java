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
        Assertions.assertArrayEquals(new double[] { 0, 1.5 }, equation.calculate(4, -6, 0));
    }

    @Test
    @DisplayName("Тест 2")
    public void test2()
    {
        Assertions.assertNull(equation.calculate(466, -6, 0));
    }
}
