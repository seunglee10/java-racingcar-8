package racingcar.controller;


import racingcar.model.Cars;
import racingcar.model.CarsParser;
import racingcar.validator.AttemptValidator;
import racingcar.validator.CarsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 자동차 이름 입력 + 검증 + 파싱
        String carNamesInput = inputView.carNames();
        CarsValidator.validateCarNames(carNamesInput);

        // 인스턴스 Parser 객체 생성
        CarsParser parser = new CarsParser();
        List<String> carNames = parser.parseCarNames(carNamesInput);

        // 시도 횟수 입력 + 검증 + 파싱
        String attemptsInput = inputView.attemptCount();
        AttemptValidator.validateAttemptCount(attemptsInput);
        int attempt = Integer.parseInt(attemptsInput);

        // Cars, RacingService 초기화
        Cars cars = new Cars(carNames);

        // 라운드별 결과 출력
        for (int i =0; i <attempt; i++) {
            cars.moveAllCars();
            outputView.printRoundResult(cars);
        }

        // 최종 우승자 출력
        List<String> winners = cars.getWinnerNames();
        outputView.printWinners(winners);
    }
}
