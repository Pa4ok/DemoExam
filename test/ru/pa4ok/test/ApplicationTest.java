package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

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
public class ApplicationTest
{
    @Test
    @DisplayName("Успешный тест на подключение к бд")
    public void connectionTest1()
    {
        Exception error = null;
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam2", "root", "1234")) {
        } catch (Exception e) {
            error = e;
        }
        Assertions.assertNull(error);
    }

    @Test
    @DisplayName("Не успешный тест на подключение к бд")
    public void connectionTest2()
    {
        Exception error = null;
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam2", "aboba", "1234")) {
        } catch (Exception e) {
            error = e;
        }
        Assertions.assertNotNull(error);
    }
}
