package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import java.util.List;

public class OutputView {
    // 한 라운드 결과 출력
    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println(); // 라운드 간 구분
    }

    // 최종 우승자 출력
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }



}
