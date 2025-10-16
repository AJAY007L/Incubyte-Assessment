package com.incubyte;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    @Test
    void add_EmptyString_ReturnsZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void add_SingleNumber_ReturnsValue() {
        assertEquals(5, StringCalculator.add("5"));
    }

    @Test
    void add_TwoNumbers_CommaSeparated() {
        assertEquals(8, StringCalculator.add("3,5"));
    }
}