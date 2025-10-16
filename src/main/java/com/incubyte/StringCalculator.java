package com.incubyte;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return parseSingle(numbers);
    }

    private static int parseSingle(String numbers) {
        return Integer.parseInt(numbers);
    }
}