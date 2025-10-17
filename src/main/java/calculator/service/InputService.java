package calculator.service;
import camp.nextstep.edu.missionutils.Console;

public class InputService {

    // 1. user input을 받음
    public String getInput() {
        return checkEmpty(Console.readLine());
    }
    // TODO 2. input 값 검증하기

    private String checkEmpty(String user_input) {
        return user_input.isEmpty() ? "0" : user_input;
    }
}
