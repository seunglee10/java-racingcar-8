package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 전진 시 위치 1 증가")
    void move_Should_In_crease_Position() {
        Car car = new Car("pobi");
        int before = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(before);
    }
}
