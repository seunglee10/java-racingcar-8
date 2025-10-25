package racingcar.controller;


import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 자동차 이름 입력 + 검증 + 파싱
        String carNamesInput = inputView.carNames();
//        RacingValidator.validateCarNames(carNamesInput);
//        List<String> carNames = inputView.parseCarNames(carNamesInput);
//
//        // 시도 횟수 입력 + 검증 + 파싱
//        String attemptsInput = inputView.attemptCount();
//        RacingValidator.validateAttemptCount(attemptsInput);
//        int attempts = RacingValidator.parseAttemptCount(attemptsInput);
//
//        // Cars/Service 로직과 연결
//        System.out.println("입력 완료: " + carNames + ", 시도 횟수: " + attempts);
//
//        // Cars, RacingService 초기화
//        Cars cars = new Cars(carNames);
//        RacingService service = new RacingService(cars, attempts);
//        service.race();
//
//        // 레이스 진행 및 라운드별 출력
//        for (int i = 0; i < attempts; i++) {
//            service.getCars().moveAllCars();
//            outputView.printRoundResult(service.getCars());
//        }
//
//        // 5. 최종 우승자 출력
//        List<String> winners = service.getCars().getWinnerNames();
//        outputView.printWinners(winners);
//
    }


}
