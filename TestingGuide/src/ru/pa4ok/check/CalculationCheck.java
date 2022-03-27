package ru.pa4ok.check;

import org.junit.jupiter.api.Assertions;
import ru.pa4ok.testguide.Calculation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class CalculationCheck {
    private Calculation classCalculation=new Calculation();

    //<editor-fold desc="Easy Test Methods">
    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_01()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_01.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_01.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_02()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_02.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_02.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_03()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_03.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_03.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_04()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_04.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_04.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_05()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_05.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_05.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_06()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_06.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_06.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_07()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_07.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_07.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_08()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_08.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_08.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_09()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_09.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_09.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_10()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_10.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_10.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_11()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_11.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_11.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_12()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_12.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_12.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_13()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_13.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_13.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_14()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_14.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_14.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_15()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_15.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_15.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_16()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_16.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_16.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_17()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_17.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_17.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_18()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_18.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_18.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_19()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_19.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_19.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Easy_20()
    {
        // Arrange
        List < String > data = readInputData("InputData_Easy_20.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Easy_20.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
    //</editor-fold>

    //<editor-fold desc="Hard Test Methods">
    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_01()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_01.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_01.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_02()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_02.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_02.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_03()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_03.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_03.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_04()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_04.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_04.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_05()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_05.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_05.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_06()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_06.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_06.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_07()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_07.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_07.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_08()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_08.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_08.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_09()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_09.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_09.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void quantityForProduct_Hard_10()
    {
        // Arrange
        List < String > data = readInputData("InputData_Hard_10.txt");

        int productType = Integer.parseInt(data.get(0));
        int materialType = Integer.parseInt(data.get(1));
        int count = Integer.parseInt(data.get(2));
        float width = Float.parseFloat(data.get(3));
        float length = Float.parseFloat(data.get(4));

        int expected = readOutputData("OutputData_Hard_10.txt");

        // Act
        int actual = classCalculation.getQuantityForProduct(productType, materialType, count, width, length);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
    //</editor-fold>

    private List<String> readInputData(String fileName)
    {
        String path = "TestingData/" + fileName;

        List<String> data = new ArrayList<>();
        try
        {
            data = Files.readAllLines(Paths.get(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    private int readOutputData(String fileName)
    {
        String path = "TestingData/" + fileName;

        int data = 0;
        try
        {
            data = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(0));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}