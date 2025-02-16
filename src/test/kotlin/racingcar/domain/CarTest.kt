package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    private val car = Car("a,b,c")

    @Test
    fun `랜덤 숫자가 4이상인 경우 전진 여부 테스트`() {
        car.moveOrStop(4)
        val expected = 1
        val result = car.getPosition()

        assertEquals(expected, result)
    }

    @Test
    fun `여러번 호출 했을 경우 이동 횟수를 확인하는 전진 횟수 테스트`() {
        car.moveOrStop(5)
        car.moveOrStop(3)
        car.moveOrStop(6)

        val expected = 2
        val result = car.getPosition()

        assertEquals(expected, result)
    }
}
