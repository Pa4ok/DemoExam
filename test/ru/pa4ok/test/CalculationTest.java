package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.demoexam.test.Calculation;

/**
 * библиотека для тестов: org.junit.jupiter:junit-jupiter:5.4.2
 *
 * ru.itmo.test.QuadraticEquation
 * - public double[] calculate(double a, double b, double c)
 *
 * функция возвращает массив корней (длина 0/1/2) (если корней нет return new double[0])
 * входные значения ограничены числами от -100 до 100 (если не подходит return null)
 *
 * реализовать функцию и 10 тестов к ней
 */
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
    @DisplayName("Простой тест 2")
    public void test2()
    {
        Assertions.assertEquals(21846, calculation.getQuantityForProduct(1, 1, 22, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 3")
    public void test3()
    {
        Assertions.assertEquals(74340, calculation.getQuantityForProduct(2, 2, 33, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 4 на невалидное значение")
    public void test4()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10, 2, 33, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 5 на невалидное значение")
    public void test5()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(1, 10, 33, 20, 45));
    }

    @Test
    @DisplayName("Сложный тест 1")
    public void test6()
    {
        Assertions.assertEquals(75436, calculation.getQuantityForProduct(2, 2, 33, 20.228F, 45.1487F));
    }

    @Test
    @DisplayName("Сложный тест 2")
    public void test7()
    {
        Assertions.assertEquals(75555, calculation.getQuantityForProduct(2, 2, 33, 20.123F, 45.456F));
    }
}
