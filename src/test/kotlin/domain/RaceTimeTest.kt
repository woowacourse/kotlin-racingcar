package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceTimeTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `경주는 10회 이하로만 반복할 수 있다`(input: Int) {
        Assertions.assertDoesNotThrow { RaceTime(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 11])
    fun `경주를 1회 미만 혹은 10회를 초과해서 반복할 수 없다`(input: Int) {
        val exception = assertThrows<IllegalArgumentException> { RaceTime(input) }
        assertThat(exception.message).isEqualTo(RaceTime.ERROR_NOT_IN_RANGE)
    }
}
