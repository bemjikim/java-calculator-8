package calculator.util;

import calculator.enums.ErrorMessageTemplate;

import java.util.Objects;

public class Validator {
    // 숫자 유효성 검증 메서드
    public static void validateNumber(String numbers) {
        if (Objects.equals(numbers, "")) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_LINEAR_DELIMITER.getMessage());
        }
        try {
            int linear_num = Integer.parseInt(numbers.trim());
            if (linear_num <= 0) {
                throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_NONPOSITIVE_NUMBER.getMessage() + linear_num);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_NUMBER_FORMAT.getMessage() + numbers);
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
