package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // Setting
        CalculatorController calculatorController = CalculatorController.settingClass();
        // Run
        calculatorController.runCalculator();
    }
}
