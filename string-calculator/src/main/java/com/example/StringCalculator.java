package com.example;

import java.util.stream.Stream;

public class StringCalculator {

    public int add(String input) {
        return sum(removeDelimiter(input));
    }

    private String[] removeDelimiter(String input) {

        if (input.contains(",")) {
            return input.split(",");
        } else {
            return new String[]{input};
        }
    }

    private static int sum(String[] nums) {

//        int sum = 0;
//
//        for (String num : nums) {
//            sum += toInt(num);
//        }
//
//        return sum;

        return Stream.of(nums)
                .map(num -> toInt(num))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int toInt(String input) {

        if (input.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(input);
    }
}
