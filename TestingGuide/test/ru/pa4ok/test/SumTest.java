package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumTest
{
    public static int sum(int a, int b) {
        return a + b;
    }

    @Test
    @DisplayName("Правильное тестирование сложения")
    public void testSum1()
    {
        Assertions.assertEquals(10, sum(5, 5));
    }

    @Test
    @DisplayName("Неправильное тестирование сложения")
    public void testSum2()
    {
        Assertions.assertEquals(10, sum(5, 4));
    }
}
