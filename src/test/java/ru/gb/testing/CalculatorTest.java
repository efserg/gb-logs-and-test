package ru.gb.testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

    private static Calculator calc;

    @BeforeClass
    public static void init() {
        System.out.println("init calc");
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(calc.add(2, 2), 4);
    }

    @Test
    public void testDiv10By5() {
        Assert.assertEquals(calc.div(10, 5), 2);
    }

    @Test(expected = ArithmeticException.class)
    public void testArithmeticException() {
        calc.div(10, 0);
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void justFail() {
        Assert.fail();
    }

    @Test(expected = ArithmeticException.class)
    public void testDivBy0() {
        calc.div(10, 0);
    }

    @Ignore("Выключенный тест")
    @Test
    public void testEmpty() {
        Assert.fail();
    }

}