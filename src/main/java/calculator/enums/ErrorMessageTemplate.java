package calculator.enums;

public enum ErrorMessageTemplate {
    INVALID_NEGATIVE_NUMBER("입력 값에 음수는 포함될 수 없습니다."),
    INVALID_NUMBER_FORMAT("입력 값에 유효하지 않는 숫자는 포함될 수 없습니다.");
    // TODO: 더 많은 에러 메시지들 생성

    private final String message;

    ErrorMessageTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
