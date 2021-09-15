package ru.gb.testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParametrizedTest {
    private Calculator calc;

    private int x1;
    private int x2;
    private int res;

    @Parameterized.Parameters
    public static Collection abracadabra() {
        return Arrays.asList(
                new Object[][]{
                        {2, 5, 7},
                        {3, 3, 6},
                        {1, 1, 2},
                        {5, 5, 10}
                }
        );
    }

    public ParametrizedTest(int x1, int x2, int res) {
        this.x1 = x1;
        this.x2 = x2;
        this.res = res;
    }

    @After
    public void tearDown() throws Exception {
        calc = null;
    }

    @Before
    public void init() {
        System.out.println("init calc");
        calc = new Calculator();
    }

    @Test
    public void paramAddingTest() {
        Assert.assertEquals(res, calc.add(x1, x2));
    }
}
