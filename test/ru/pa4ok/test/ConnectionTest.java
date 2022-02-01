package ru.pa4ok.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest
{
    @Test
    @DisplayName("Удачный тест")
    public void test1()
    {
        Exception error = null;
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexam1", "root", "1234")) {
        } catch (Exception e) {
            error = e;
        }
        Assertions.assertEquals(null, error);
    }

    @Test
    @DisplayName("Неудачный тест")
    public void test2()
    {
        Exception error = null;
        try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoexfwefewam1", "fwepfhweofheiwu", "1wffewf234")) {
        } catch (Exception e) {
            error = e;
        }
        Assertions.assertEquals(null, error);
    }
}
