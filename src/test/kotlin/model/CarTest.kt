package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Random

class CarTest {
    val cars: MutableList<Car> = mutableListOf(Car("hwan", 2), Car("sia", 4))

    @Test
    fun `랜덤 숫자가 4 이상일 때 전진한다`() {
        val random = Random(1234)
        val position = cars[0].currentPosition
        cars[0].moveCar(random)
        assertEquals(position + 1, cars[0].currentPosition)
    }
}
