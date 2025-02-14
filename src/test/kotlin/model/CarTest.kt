package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OverFour : IntGenerator {
    override fun randomGenerator() = 4
}

class UnderThree : IntGenerator {
    override fun randomGenerator() = 3
}

class CarTest {
    @Test
    fun `랜덤 숫자가 4 이상일 때 전진한다`() {
        val car = Car("xia", randomMaker = OverFour())
        val position = car.currentPosition
        car.moveCar()
        assertEquals(position + 1, car.currentPosition)
    }

    @Test
    fun `랜덤 숫자가 3 이하일 때 정지한다`() {
        val car = Car("xia", randomMaker = UnderThree())
        val position = car.currentPosition
        car.moveCar()
        assertEquals(position, car.currentPosition)
    }
}
