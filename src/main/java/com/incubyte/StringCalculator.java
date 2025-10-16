package com.incubyte;

import java.util.Arrays;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        String delimiters = ",|\n";
        String numbers = input;
        if (input.startsWith("//")) {
            int idx = input.indexOf("\n");
            delimiters = Pattern.quote(input.substring(2, idx));
            numbers = input.substring(idx + 1);
        }
        String[] tokens = numbers.split(delimiters);
        return Arrays.stream(tokens)
                .mapToInt(StringCalculator::parseSingle)
                .sum();
    }

    private static String normalizeDelimiters(String input) {
        String normalized = input.replace("\n",",");
        return normalized;
    }

    private static int parseSingle(String number) {
        return Integer.parseInt(number);
    }
}