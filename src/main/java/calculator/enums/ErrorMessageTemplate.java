package calculator.enums;

public enum ErrorMessageTemplate {
    INVALID_NONPOSITIVE_NUMBER("입력 값에 양수가 아닌 수는 포함될 수 없습니다: "),
    INVALID_NUMBER_FORMAT("입력 값에 유효하지 않는 숫자 or 구분자는 포함될 수 없습니다: "),
    // TODO: 더 많은 에러 메시지들 생성
    // "입력 값에 유효하지 않는 형식은 포함될 수 없습니다."
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자의 형식이 올바르지 않습니다."),
    INVALID_LINEAR_DELIMITER("문자열에서 연속된 구분자는 허용하지 않습니다."),
    INVALID_ONE_MORE_CUSTOM_DELIMITER("커스텀 구분자는 한 개의 문자로 이루어져야 합니다.");


    private final String message;

    ErrorMessageTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
