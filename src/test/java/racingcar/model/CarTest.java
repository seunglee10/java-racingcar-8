package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 이름 생성 테스트")
    void get_Car_Name() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }
}
