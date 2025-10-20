package calculator;

import calculator.service.DelimiterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterTest {
    private DelimiterService delimiterService;

    @BeforeEach
    void setUp() {
        delimiterService = new DelimiterService();
    }

    @Test
    void 기본_구분자_추출() {
        String input = "1,2,3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 기본_구분자_추출2() {
        String input = "1:2:3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 기본_혼합_구분자_추출() {
        String input = "1:2,3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 커스텀_구분자_추출() {
        String input = "//;\\n1;2;3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 연속_커스텀_구분자_추출() {
        String input = "//;\\n//@\\n1;2@3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 기본_커스텀_혼합_구분자_추출() {
        String input = "//;\\n1;2,3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }

    @Test
    void 특수문자_커스텀_구분자_추출() {
        String input = "///\\n1/2/3";
        String customDelimiter = Arrays.toString(delimiterService.splitDelimiter(input));
        assertThat("[1, 2, 3]").isEqualTo(customDelimiter);
    }
}
