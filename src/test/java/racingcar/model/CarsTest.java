package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CarsTest {
    @Test
    @DisplayName("getWinnerNames는 가장 멀리간 자동차 이름 반환")
    void get_Winner_Names_Should_Return_Car_With_MaxPosition() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        // 위치 강제로 세팅
        for (int i = 0; i < 3; i++) car1.move();
        for (int i = 0; i < 2; i++) car2.move();

        Cars cars = new Cars(List.of("pobi", "woni"));
        cars.getCars().set(0, car1);
        cars.getCars().set(1, car2);

        List<String> winners = cars.getWinnerNames();
        assertThat(winners).containsExactly("pobi");
    }

}
