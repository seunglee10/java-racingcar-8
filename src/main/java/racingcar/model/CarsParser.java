package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsParser {
    // 이스케이프 문자 제거
    // 문자열 split
    // 각 문자열에 대한 검사(빈 문자열밖에 없나?
    // 만들어진 자동차 목록 반환 - >Controller

    public List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
