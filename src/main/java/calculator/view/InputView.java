package calculator.view;

import calculator.enums.UITemplate;

public class InputView {
    // 사용자 입력 UI 메서드
    public void printInputUI() {
        System.out.println(UITemplate.INPUT_MESSAGE.getMessage());
    }
}
