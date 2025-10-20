package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest extends NsTest {
    @Test
    void 한_문자만_입력() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용1() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1:20:3");
            assertThat(output()).contains("결과 : 24");
        });
    }

    @Test
    void 기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_2연속_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//a\\n1;2a3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_기본_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_특수문자로_사용() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
