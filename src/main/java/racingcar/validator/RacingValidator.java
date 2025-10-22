package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class RacingValidator {
    public static void validateCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해야 합니다.");
        }
        String[] names = input.split(",");
        Set<String> nameSet = new HashSet<>();

        for (String name : names) {
            String trimmedName = name.trim();

            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (nameSet.contains(trimmedName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다: " + trimmedName);
            }

            nameSet.add(trimmedName);
        }
    }

    public static void validateAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수만 가능합니다.");
        }
    }

    public static int parseAttemptCount(String input) {
        return Integer.parseInt(input);
    }


}
