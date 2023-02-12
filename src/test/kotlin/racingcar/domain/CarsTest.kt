package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.Cars

class CarsTest {
    @Test
    fun `자동차 이름을 입력받아 자동차를 생성한다`() {
        val cars = Cars.create(listOf("test1", "test2", "test3"))
        assertEquals(3, cars.size)
    }

    @Test
    fun `자동차 이름을 입력받아 자동차 이름을 저장한다`() {
        val cars = Cars.create(listOf("test1", "test2", "test3"))
        assertEquals(listOf("test1", "test2", "test3"), cars.map { it.name })
    }
}
