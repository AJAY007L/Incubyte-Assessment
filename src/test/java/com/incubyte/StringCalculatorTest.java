package com.incubyte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void add_MultipleNumbers_ReturnsSum() {
        assertEquals(15, StringCalculator.add("1,2,3,4,5"));
    }

    @Test
    void add_SupportsNewLineDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    void add_CustomDelimiter_Semicolon() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void add_NegativeNumbers_ThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> StringCalculator.add("2,-4,3,-5"));
        assertTrue(ex.getMessage().contains("-4,-5"));
    }

    @Test
    void add_NumbersGreaterThan1000_Ignored() {
        assertEquals(2, StringCalculator.add("2,1001"));
    }

    @Test
    void add_CustomDelimiterOfAnyLength() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }
}