package ru.gb.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParametrizedTest {
    private static Calculator calc;

    @BeforeAll
    public static void init() {
        calc = new Calculator();
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(0, 0, 0),
                Arguments.of(2, 2, 4),
                Arguments.of(-1, 1, 0),
                Arguments.of(2000, 2001, 4001),
                Arguments.of(2, 2, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    public void test(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void testCsv(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }
}
