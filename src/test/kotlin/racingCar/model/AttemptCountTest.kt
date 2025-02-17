package racingCar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AttemptCountTest {
    private lateinit var attemptCount: AttemptCount

    @Test
    @DisplayName("시도횟수가 입력되지 않으면 예외가 발생한다.")
    fun attemptCountNullTest() {
        assertThrows<IllegalArgumentException> {
            attemptCount = AttemptCount("")
        }
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력되면 예외가 발생한다.")
    fun attemptCountNotIntegerTest() {
        assertThrows<IllegalArgumentException> {
            attemptCount = AttemptCount("1A")
        }
    }

    @Test
    @DisplayName("시도횟수가 1미만이면 예외가 발생한다.")
    fun attemptCountLessThanOneTest() {
        assertThrows<IllegalArgumentException> {
            attemptCount = AttemptCount("0")
        }
        assertThrows<IllegalArgumentException> {
            attemptCount = AttemptCount("-1")
        }
    }

    @Test
    @DisplayName("1이상의 자연수가 입력되면 생성되고 숫자를 반환한다.")
    fun attemptCountTest() {
        attemptCount = AttemptCount("1")
        assertEquals(attemptCount.getCount(), 1)
    }
}
