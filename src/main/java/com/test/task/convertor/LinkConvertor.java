package com.test.task.convertor;

import org.springframework.stereotype.Component;

@Component
public class LinkConvertor {
    private final int DIGIT = 62;

    private final char[] sixtyTwoDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public String convertLink(String originalUrl) {
        int number = originalUrl.chars().sum();

        StringBuilder value = new StringBuilder();

        while (number != 0) {
            value.append(sixtyTwoDigits[number % DIGIT]);
            number /= DIGIT;
        }
        return value.toString();
    }
}
