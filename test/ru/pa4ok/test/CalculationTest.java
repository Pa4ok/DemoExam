package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.pa4ok.demoexam.test.Calculation;

/**
 * библиотека для тестов: org.junit.jupiter:junit-jupiter:5.8.2
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
        Assertions.assertEquals(24780, calculation.getQuantityForProduct(2, 2, 11, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 3 на несуществующий тип продукта")
    public void test3()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(10, 2, 11, 20, 45));
    }

    @Test
    @DisplayName("Простой тест 4 на несуществующий тип материала")
    public void test4()
    {
        Assertions.assertEquals(-1, calculation.getQuantityForProduct(1, 10, 11, 20, 45));
    }

    @Test
    @DisplayName("Сложный тест 1")
    public void test5()
    {
        Assertions.assertEquals(25369, calculation.getQuantityForProduct(2, 2, 11, 20.32F, 45.344F));
    }
}
