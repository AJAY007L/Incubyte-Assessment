package com.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        String delimiters = extractDelimiter(input);
        String numbers = input.startsWith("//") ? input.substring(input.indexOf("\n") + 1) : input;
        String[] tokens = numbers.split(delimiters);

        int[] nums = Arrays.stream(tokens)
                .mapToInt(StringCalculator::parseSingle)
                .toArray();

        List<Integer> negatives = Arrays.stream(nums)
                .filter(n -> n < 0)
                .boxed()
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            // Format negatives into a comma-separated string without spaces
            String negativesStr = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException("Negative not allowed: " + negativesStr);
        }
        return Arrays.stream(nums)
                .filter(n -> n <= 1000)  // Ignore numbers greater than 1000
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
            String delimiterSection = input.substring(2, idx);
            if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
                // Strip brackets and quote regex special characters
                delimiterSection = delimiterSection.substring(1, delimiterSection.length() - 1);
                return Pattern.quote(delimiterSection);
            } else {
                return Pattern.quote(delimiterSection);
            }
        }
        return ",|\n";  // default delimiters
    }
}