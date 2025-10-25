package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsValidatorTest {

    private CarsValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarsValidator();
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외 발생")
    void car_Names_Null_Should_Throw_Exception() {
        assertThatThrownBy(() -> validator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외 발생")
    void carNames_Over_Five_Chars_Should_Throw_Exception() {
        assertThatThrownBy(() -> validator.validateCarNames("pobiiii,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
