package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    // 자동차 이름 리스트를 받아 Car 객체 생성
    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    // 모든 자동차 이동
    public void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    // 자동차 리스트 반환
    public List<Car> getCars() {
        return cars;
    }

    // 최종 우승자 이름 반환
    public List<String> getWinnerNames() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
