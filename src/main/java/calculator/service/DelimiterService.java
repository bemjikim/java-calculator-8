package calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Validator.validateCustomDelimiter;
import static calculator.util.Validator.validateNumber;

public class DelimiterService {
    // Delimiter에 CustomDelimiter 추가 및 분리 메서드
    public long[] splitDelimiter(String user_input) {
        String delimiter =",|:";

        while (user_input.startsWith("//")) {
            int customDelimiterIndex = validateCustomDelimiter(user_input);
            delimiter += checkSepcialDelimiter(user_input, customDelimiterIndex) + user_input.substring(2, customDelimiterIndex);
            user_input = user_input.substring(customDelimiterIndex + 2);
        }

        String[] numbers = user_input.split(delimiter);

        return Arrays.stream(numbers)
                .mapToLong(this::checkNumberArray)
                .toArray();
    }

    // Custom Delimiter 특수문자 처리 메서드
    private String checkSepcialDelimiter(String user_input, int customDelimiterIndex) {
        String specialRegex = "[\\\\.^$|?*+()\\[\\]{}]";

        Pattern pattern = Pattern.compile(specialRegex);
        Matcher matcher = pattern.matcher(user_input);

        if (matcher.find()) {
            return "|\\";
        }

        return "|";
    }


    // 숫자 유효성 검사 메서드
    private long checkNumberArray(String numbers) {
        validateNumber(numbers);
        return Integer.parseInt(numbers.trim());
    }


}

