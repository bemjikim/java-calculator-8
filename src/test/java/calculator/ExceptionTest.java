package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest extends NsTest {
    @Test
    void 양수가_아닌_수_예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 양수가_아닌_수_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_양식_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2,3//,\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_양식_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,\n1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_양식_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_양식_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_양식_예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//@@\\n1@@2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_양식_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_양식_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_양식_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 등록되지_않은_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1@3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_합이_자료형을_넘어갈_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775800,9223372036854775800"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
