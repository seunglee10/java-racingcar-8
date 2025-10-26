package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsParserTest {

    private final CarsParser parser = new CarsParser();

    @Test
    @DisplayName("쉼표를 기준으로 이름 목록 파싱")
    void valid_input_should_be_parsed_correctly() {
        String input = "pobi,woni";

        List<String> carNames = parser.parseCarNames(input);

        assertThat(carNames).containsExactly("pobi", "woni");
    }

    @Test
    @DisplayName("이스케이프 문자 제거")
    void all_escape_characters_should_be_removed() {
        // Given
        String input = "wo\tni,\n";

        // When
        List<String> carNames = parser.parseCarNames(input);

        // Then
        assertThat(carNames).containsExactly( "wo\\tni", "\\n");
    }

    @Test
    @DisplayName("입력 양 끝 공백 제거")
    void leading_and_trailing_spaces_should_be_trimmed() {
        // Given
        String input = " carA,carB , carC ";

        // When
        List<String> carNames = parser.parseCarNames(input);

        // Then
        assertThat(carNames).containsExactly("carA", "carB", "carC");
    }
}
