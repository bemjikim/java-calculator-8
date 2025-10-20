package calculator.enums;

public enum ErrorMessageTemplate {
    INVALID_NONPOSITIVE_NUMBER("입력 값에 양수가 아닌 수는 포함될 수 없습니다: "),
    INVALID_SUM_OVERFLOW("결과 값에 오버플로우가 발생했습니다: "),
    INVALID_NUMBER_FORMAT("입력 값에 유효하지 않는 숫자 or 구분자는 포함될 수 없습니다: "),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자의 형식이 올바르지 않습니다."),
    INVALID_CALCULATE_FORMAT("덧셈할 문자열의 포멧을 지켜주세요 ex) 1,2,3"),
    INVALID_ONE_MORE_CUSTOM_DELIMITER("커스텀 구분자는 한 개의 문자로 이루어져야 합니다.");

    private final String message;

    ErrorMessageTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
