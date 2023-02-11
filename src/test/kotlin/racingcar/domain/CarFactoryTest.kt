package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.CarFactory
import racingcar.racingcar.domain.numbergenerator.RandomNumberGenerator

class CarFactoryTest {
    @Test
    fun `자동차 이름을 입력받아 자동차를 생성한다`() {
        val carFactory = CarFactory(listOf("test1", "test2", "test3"))
        assertEquals(3, carFactory.cars.size)
    }

    @Test
    fun `자동차 이름을 입력받아 자동차 이름을 저장한다`() {
        val carFactory = CarFactory(listOf("test1", "test2", "test3"))
        assertEquals(listOf("test1", "test2", "test3"), carFactory.carNames)
    }

    @Test
    fun `경기 후 기록이 저장된다`() {
        val carFactory = CarFactory(listOf("test1", "test2", "test3"))
        carFactory.moveCars(RandomNumberGenerator())
        assertEquals(1, carFactory.result.size)
    }
}
