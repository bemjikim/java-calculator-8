package calculator.service;
import camp.nextstep.edu.missionutils.Console;

public class InputService {
    // User Input을 처리하는 메서드
    public String getInput() {
        return checkUserInput(Console.readLine());
    }

    // User Input이 공백인지 확인하는 메서드
    private String checkUserInput(String user_input) {
        return user_input.isEmpty() ? "0" : user_input;
    }
}
