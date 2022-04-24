package org.example;

import hu.meiit.haladojava.calculator.Service;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceTest
{
    @Test
    public void separationTest(){
        //Given
        String operation = "7+4";
        Service service = new Service();
        String[] separatedValues;
        //When
        separatedValues = service.Separate(operation);
        //Then
        assertEquals(separatedValues[0],"7");
        assertEquals(separatedValues[1],"+");
        assertEquals(separatedValues[2],"4");
    }

    @Test
    public void checkStrLengthTest(){
        //Given
        Service service = new Service();
        String[] strArr = {"1","+","4"};
        //When,Then
        assertTrue(service.checkStrLenght(strArr));
    }

    @Test
    public void checkStrLengthFalseTest(){
        //Given
        Service service = new Service();
        String[] strArr = {"1","+","4","4"};
        //When,Then
        assertFalse(service.checkStrLenght(strArr));
    }

    @Test
    public void convertToIntTest(){
        //Given
        Service service = new Service();
        String str = "7";
        float expected = 7;
        //When
        float a = service.convertToInt(str);
        //Then
        assertEquals(a,expected,.1);
    }

    @Test
    public void convertToIntFailTest(){
        //Given
        Service service = new Service();
        String str = "a";
        float expected = 0;
        //When
        float a = service.convertToInt(str);
        //Then
        assertEquals(a,expected,.1);
    }
}
