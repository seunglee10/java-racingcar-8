package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsParser {

    // 입력 문자열에서 역슬래시 제거
    private String removeEscapeCharacters(String input) {
        return input.replace("\t", "\\t")
                .replace("\n", "\\n");
    }

    public List<String> parseCarNames(String input) {
        String cleanedInput = removeEscapeCharacters(input);

        return Arrays.stream(cleanedInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
