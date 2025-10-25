package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptValidatorTest {
    private AttemptValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AttemptValidator();
    }


    @Test
    @DisplayName("시도 횟수가 정수가 아니면 예외 발생")
    void attempt_Count_Not_Integer_Should_Throw_Exception() {
        assertThatThrownBy(() -> validator.validateAttemptCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수만 가능합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하이면 예외 발생")
    void attempt_Count_Zero_Or_Negative_Should_Throw_Exception() {
        assertThatThrownBy(() -> validator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
