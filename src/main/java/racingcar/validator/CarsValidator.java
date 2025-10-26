package racingcar.validator;

public class CarsValidator {
    public static void validateCarNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException("자동차 이름은 반드시 입력해야 합니다.");
        }

        String[] names = input.split(",");

        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}