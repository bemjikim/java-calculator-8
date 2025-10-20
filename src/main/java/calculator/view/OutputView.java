package calculator.view;

import calculator.enums.UITemplate;

public class OutputView {
    // 출력 UI 메서드
    public void printOutputUI(long result) {
        System.out.print(UITemplate.OUTPUT_MESSAGE.getMessage() + result);
    }
}
