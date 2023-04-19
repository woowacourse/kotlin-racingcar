package racingCar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CountTest {

    @ParameterizedTest(name = "Count 는 생성 시 1 보다 작으면 예외를 발생한다.")
    @ValueSource(ints = [-1, 0])
    fun exceptionTest(number: Int) {
        assertThrows<IllegalArgumentException>("숫자를 입력하세요") {
            Count(number)
        }
    }

    @ParameterizedTest(name = "Count 는 생성 시 1 이상이면 생성된다.")
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun validTest(number: Int) {
        assertDoesNotThrow { Count(number) }
    }

    @ParameterizedTest(name = "Count 는 양수일 때 기회를 가진다.")
    @ValueSource(ints = [2, 3, 4, 5])
    fun hasOpportunityTest(number: Int) {
        // given
        val count = Count(number)

        // when
        count.deduct()

        // then
        assertEquals(count.isOpportunity(), true)
    }

    @DisplayName("Count 는 음수일 때 기회를 가지지 않는다")
    @Test
    fun hasNoOpportunityTest() {
        // given
        val count = Count(1)

        // when
        count.deduct()

        // then
        assertEquals(count.isOpportunity(), false)
    }
}
