package domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceTimeTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `경주 시도 횟수가 10 이하의 자연수이면 에러가 발생하지 않는다`(input: Int) {
        Assertions.assertDoesNotThrow { RaceTime(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 11])
    fun `경주 시도 횟수가 1 미만 10 초과면 에러가 발생한다`(input: Int) {
        val exception = assertThrows<IllegalArgumentException> { RaceTime(input) }
        org.assertj.core.api.Assertions.assertThat(exception.message).isEqualTo(RaceTime.ERROR_NOT_IN_RANGE)
    }
}
