package racingCar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car("공백")
        val initialPosition = 0
        Assertions.assertEquals(initialPosition, car.position)
    }

    @Test
    fun `1번 전진한 후 자동차는 이전 위치보다 1 앞서있다`() {
        // given:
        val car = Car("뭉치")
        val previousPosition = car.position
        // when:
        car.moveForward()
        // then:
        Assertions.assertTrue(car.position == previousPosition + 1)
    }

    @Test
    fun `전진을 못하면 자동차는 이전 위치와 같다`() {
        // given:
        val car = Car("뭉치")
        val previousPosition = car.position
        // when:
        // then:
        Assertions.assertTrue(car.position == previousPosition)
    }
}
