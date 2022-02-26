package ru.gb.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class HamcrestSample {

    private Calculator calc = new Calculator();

    @Test
    public void t1() {
        assertThat(calc.add(1, 1), equalTo(2L));
        assertThat(calc.add(1, 1), greaterThan(0L));
        assertThat(calc.add(1, 1), anyOf(equalTo(2L), greaterThan(0L)));
        assertThat(calc.add(1, 1), allOf(equalTo(2L), greaterThan(1L), lessThan(3L)));
    }
}
