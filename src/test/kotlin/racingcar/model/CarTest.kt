package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["buna", "otter", "jack", "son"])
    fun `자동차 생성 노말 테스트`(name: String) {
        assertDoesNotThrow {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["refactoring", "reviewer", "", "jackson"])
    fun `자동차 생성 이름 길이 예외 테스트`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @Test
    fun `자동차 이동횟수 일치 테스트`() {
        val car = Car("otter")
        val moveCount = 5

        repeat(moveCount) {
            car.move()
        }

        assertEquals(moveCount, car.position)
    }
}
