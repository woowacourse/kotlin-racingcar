package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    private val hwanCar = Car("hwan")

    @Test
    fun `자동차 이름이 5자를 초과하면 에러가 발생한다`() {
        assertThatThrownBy { Car("hwannow") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차가 1칸 이동하면 현재 위치가 1 늘어난다`() {
        val position = hwanCar.currentPosition

        hwanCar.moveCar()

        assertEquals(position + 1, hwanCar.currentPosition)
    }
}
