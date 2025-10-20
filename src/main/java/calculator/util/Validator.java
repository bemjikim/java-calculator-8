package calculator.util;

import calculator.enums.ErrorMessageTemplate;

import java.util.Arrays;

public class Validator {
    // 숫자 유효성 검증 메서드
    public static void validateNumber(String numbers) {
        try {
            long linear_num = Long.parseLong(numbers.trim());

            if (linear_num <= 0) {
                throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_NONPOSITIVE_NUMBER.getMessage() + linear_num);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_NUMBER_FORMAT.getMessage() + numbers);
        }
    }

    // 문자열 형식 검증 메서드
    public static void validateFormat(String user_input, String delimiter) {
        String[] numbers = Arrays.stream(user_input.split(delimiter))
                                 .filter(s -> !s.isEmpty())
                                 .toArray(String[]::new);
        int num_delimiter_length = user_input.length();
        int linear_num_length = String.join("", numbers).length();

        int split_num_length = numbers.length;
        int delimiter_length = num_delimiter_length - linear_num_length;

        if (split_num_length - delimiter_length != 1) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_CALCULATE_FORMAT.getMessage());
        }
    }

    // Custom Delimiter 검증 메서드
    public static int validateCustomDelimiter(String user_input) {
        int start_customDelimiterIndex = user_input.indexOf("//");
        int end_customDelimiterIndex = user_input.indexOf("\\n");

        if (end_customDelimiterIndex == -1) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }

        if (end_customDelimiterIndex - start_customDelimiterIndex != 3) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_ONE_MORE_CUSTOM_DELIMITER.getMessage());
        }

        return end_customDelimiterIndex;
    }
}
