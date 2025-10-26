package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 목록에 빈 값 입력 시 에러 발생")
    void emptyCarListShouldThrowException() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,", ",pobi", "pobi,","pobi,,javaji"})
    @DisplayName("자동차 이름 공백 입력 시 에러 발생")
    void blankShouldThrowException(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 길이 5자 초과 시 에러 발생")
    void carNameLengthExceedFiveShouldThrowException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobiiii", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도 횟수에 0 또는 음수 입력 시 에러 발생")
    void notPositiveNumberShouldThrowException(String attempt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", attempt))
                        .isInstanceOf(IllegalArgumentException.class)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"3.0", "3.14"})
    @DisplayName("시도 횟수에 소수점 입력 시 에러 발생")
    void floatNumberShouldThrowException(String attempt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", attempt))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @Test
//    @DisplayName("시도 횟수가 정수 범위 초과 입력 시 에러 발생")
//    void NumberShouldThrowException() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi", "abc"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 문자 입력 시 에러 발생")
    void nonNumberShouldThrowException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


//    @Test
//    @DisplayName("자동차 이름 길이 5자 초과 시 에러 발생")
//    void ShouldThrowException() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobiiii", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

//    @Test
//    void race_singleCar_singleAttempt() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("pobi,woni", "1");
//                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//                },
//                MOVING_FORWARD, STOP
//        );
//    }
//
//    @Test
//    void raceSingleCarMultipleAttempt() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("pobi,woni", "2");
//                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//                },
//                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
//        );
//    }
//



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
