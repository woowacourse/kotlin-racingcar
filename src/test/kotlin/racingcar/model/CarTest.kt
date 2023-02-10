package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

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
