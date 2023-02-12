package racingcar.model.round

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class RoundTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "100", "${Int.MAX_VALUE}"])
    fun `1이상 Int 최대값 이하 값이 주어졌을 때, Round 객체 생성시, 예외가 발생하지 않는다`(count: String) {
        assertDoesNotThrow {
            Round(count.toInt())
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", (Int.MAX_VALUE.toLong() + 1).toString()])
    fun `1미만 Int 최대값을 초과한 값이 주어졌을 때, Round 객체 생성시, 예외가 IllegalArgumentException가 발생한다`(count: String) {
        assertThrows<IllegalArgumentException> {
            Round(count.toInt())
        }
    }
}
