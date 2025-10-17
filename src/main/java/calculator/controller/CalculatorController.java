package calculator.controller;

import calculator.service.DelimiterService;
import calculator.service.InputService;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;
    private final InputService inputService;
    private final DelimiterService delimiterService;

    private CalculatorController(InputView inputView, InputService inputService, DelimiterService delimiterService) {
        this.inputView = inputView;
        this.inputService = inputService;
        this.delimiterService = delimiterService;
    }

    // 생성 메소드
    public static CalculatorController settingClass() {
        InputView inputView = new InputView();
        InputService inputService = new InputService();
        DelimiterService delimiterService = new DelimiterService();


        return new CalculatorController(inputView, inputService, delimiterService);
    }

    // 동작
    public void runCalculator() {
        // 1. 사용자의 입력을 받음
        inputView.printInputUI();
        String user_input = inputService.getInput();

        // 2. 구분자 나누기
        long[] split_num = delimiterService.splitDelimiter(user_input);

    }

}
