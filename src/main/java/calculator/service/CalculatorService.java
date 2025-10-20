package calculator.service;

import calculator.enums.ErrorMessageTemplate;

import java.util.stream.LongStream;
import java.util.Arrays;

import static calculator.util.Validator.validateSumOverflow;

public class CalculatorService {
    // 구분자로 split 된 숫자들의 합을 구해주는 메서드
    public long cal_nums(long[] split_num) {
        return validateSumOverflow(split_num);
    }
}