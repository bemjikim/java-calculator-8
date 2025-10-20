package calculator.service;

import calculator.enums.ErrorMessageTemplate;

import java.util.stream.LongStream;
import java.util.Arrays;

public class CalculatorService {
    // 구분자로 split 된 숫자들의 합을 구해주는 메서드
    public long cal_nums(long[] split_num) {
        long result = 0;

        try {
            result = Arrays.stream(split_num)
                    .reduce(0L, Math::addExact);

        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(ErrorMessageTemplate.INVALID_SUM_OVERFLOW.getMessage() + result);
        }

        return result;
    }
}