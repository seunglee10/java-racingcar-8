package racingcar.controller;
import racingcar.view.InputView;
import racingcar.validator.RacingValidator;
import java.util.List;


public class RacingController {

    private final InputView inputView = new InputView();

    public void run() {
        // 자동차 이름 입력 + 검증 + 파싱
        String carNamesInput = inputView.carNames();
        RacingValidator.validateCarNames(carNamesInput);
        List<String> carNames = inputView.parseCarNames(carNamesInput);

        // 시도 횟수 입력 + 검증 + 파싱
        String attemptsInput = inputView.attemptCount();
        RacingValidator.validateAttemptCount(attemptsInput);
        int attempts = RacingValidator.parseAttemptCount(attemptsInput);

        // 여기서 Cars/Service 로직과 연결
        System.out.println("입력 완료: " + carNames + ", 시도 횟수: " + attempts);

    }


}
