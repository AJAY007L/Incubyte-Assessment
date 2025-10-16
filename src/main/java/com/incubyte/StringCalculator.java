package com.incubyte;

import java.util.Arrays;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        String delimiters = extractDelimiter(input);
        String numbers = input.startsWith("//") ? input.substring(input.indexOf("\n") + 1) : input;
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

    private static String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int idx = input.indexOf("\n");
            return Pattern.quote(input.substring(2, idx));
        }
        return ",|\n";  // default delimiters
    }
}