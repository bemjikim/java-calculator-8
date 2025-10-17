package calculator.enums;

public enum UITemplate {
    INPUT_MESSAGE("덧셈할 문자열을 입력해주세요."),
    OUTPUT_MESSAGE("결과 : ");

    private final String message;

    UITemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
