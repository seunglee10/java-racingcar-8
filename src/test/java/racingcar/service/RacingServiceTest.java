package racingcar.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import racingcar.model.Car;
import racingcar.model.Cars;
import java.util.List;


public class RacingServiceTest {
    @Test
    @DisplayName("race 메서드는 모든 자동차를 시도 횟수만큼 이동시킨다")
    void race_Should_Move_AllCars() {
        Cars cars = new Cars(List.of("pobi", "woni"));
        RacingService service = new RacingService(cars, 5);

        service.race();

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }
}
