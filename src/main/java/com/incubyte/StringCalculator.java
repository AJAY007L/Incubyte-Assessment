package com.incubyte;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        String[] tokens=input.split(",");
        return Arrays.stream(tokens)
                .mapToInt(StringCalculator::parseSingle)
                .sum();
    }

    private static int parseSingle(String number) {
        return Integer.parseInt(number);
    }
}