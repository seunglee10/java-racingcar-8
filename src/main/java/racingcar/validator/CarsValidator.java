package racingcar.validator;

import java.util.function.ToDoubleBiFunction;

public class CarsValidator {
    public static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    // TODO
    // 같은 이름의 자동차에 대해 에러처리 필요할 수 있음

    }
}