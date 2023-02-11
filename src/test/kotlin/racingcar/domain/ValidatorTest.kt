package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ValueSource(strings = ["", "jinini"])
    @ParameterizedTest
    fun `자동차 이름 길이 체크하는 함수 NameLengthInRange함수 테스트(자동차 이름 길이는 1~5사이) `(input: String) {
        assertThat(
            Validator.isNameLengthInRange(input),
        ).isFalse
    }

    @ValueSource(strings = ["", "a", "0d9", "-1"])
    @ParameterizedTest
    fun `실행횟수 입력받기위한 숫자인지 검증함수 테스트`(input: String) {
        assertThat(
            Validator.isNumber(input),
        ).isFalse
    }
}
