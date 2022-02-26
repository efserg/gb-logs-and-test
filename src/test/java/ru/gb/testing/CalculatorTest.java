package ru.gb.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private static Calculator calc;

    @BeforeEach
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        final Long res = calc.add(2, 2);
        assertEquals(4, res);
    }

    @Test
    public void testZeroValues() {
        final Long res = calc.add(0, 0);
        assertEquals(0, res);
    }

    @Test
    public void testMaxValues() {
        final Long res = calc.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(0x7fffffffL + 0x7fffffffL, (long) res);
    }

    @Test
    public void testMinValues() {
        final Long res = calc.add(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(-0x80000000L - 0x80000000L, (long) res);
    }

    @Test
    public void testMinAndMaxValues() {
        final Long res = calc.add(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(-1, (long) res);
    }

    @Test
    public void testCommutative() {
        final Long res1 = calc.add(1, 2);
        final Long res2 = calc.add(2, 1);
        assertEquals(res1, res2);
    }

    @Test
    public void testDivByZero() {
        assertThrows(ArithmeticException.class, () -> calc.div(1, 0));
    }


}