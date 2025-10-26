package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsValidatorTest {

    @Test
    @DisplayName("자동차 이름이 null이면 예외 발생")
    void car_Names_Null_Should_Throw_Exception() {

        String input = null;

        assertThatThrownBy(() -> CarsValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외 발생")
    void carNames_Over_Five_Chars_Should_Throw_Exception() {

        String input = "pobiiii,woni";

        assertThatThrownBy(() -> CarsValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
