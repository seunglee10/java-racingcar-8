package racingcar.service;

import racingcar.model.Cars;


public class RacingService {
    private final Cars cars;
    private final int attemptCount;

    public RacingService(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void race() {
        for (int i = 0; i < attemptCount; i++) {
            cars.moveAllCars();
        }
    }

    public Cars getCars() {
        return cars;
    }

}
