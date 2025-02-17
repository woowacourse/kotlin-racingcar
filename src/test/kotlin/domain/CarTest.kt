package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Random

class CarTest {
    private val hwanCar = Car("hwan")
    private val siaCar = Car("sia")

    @Test
    fun `자동차 이름이 5자를 초과하면 에러가 발생한다`() {
        assertThatThrownBy { Car("hwannow") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차가 1칸 이동하면 현재 위치가 1 늘어난다`() {
        val random = Random(1234)
        val position = hwanCar.currentPosition

        hwanCar.moveCar(random)

        assertEquals(position + 1, hwanCar.currentPosition)
    }

    @Test
    fun `랜덤 숫자가 4 미만인 경우, 자동차의 위치는 바뀌지 않는다`() {
        val random = Random(123)
        val position = siaCar.currentPosition

        siaCar.moveCar(random)

        assertEquals(position, siaCar.currentPosition)
    }
}
