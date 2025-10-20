package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.service.InputService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputService inputService;
    private final DelimiterService delimiterService;
    private final CalculatorService calculatorService;

    private CalculatorController(InputView inputView, OutputView outputView, InputService inputService, DelimiterService delimiterService, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputService = inputService;
        this.delimiterService = delimiterService;
        this.calculatorService = calculatorService;
    }

    // 생성 메소드
    public static CalculatorController settingClass() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputService inputService = new InputService();
        DelimiterService delimiterService = new DelimiterService();
        CalculatorService calculatorService = new CalculatorService();

        return new CalculatorController(inputView, outputView, inputService, delimiterService, calculatorService);
    }

    // 동작
    public void runCalculator() {
        // 1. 사용자의 입력을 받음
        inputView.printInputUI();
        String user_input = inputService.getInput();

        // 2. 구분자 나누기
        long[] split_num = delimiterService.splitDelimiter(user_input);

        // 3. 더하기
        long result = calculatorService.cal_nums(split_num);
        outputView.printOutputUI(result);
    }
}
