package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsParser {
    // 이스케이프 문자 제거
    // 문자열 split
    // 각 문자열에 대한 검사(빈 문자열밖에 없나?
    // 만들어진 자동차 목록 반환 - >Controller


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
