package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.racingcar.domain.Cars

class CarsTest {
    @Nested
    inner class `자동차들을 생성할 때` {
        @Test
        fun `자동차 이름들을 입력받는다`() {
            val cars = Cars.create(listOf("test1", "test2", "test3"))
            assertEquals(listOf("test1", "test2", "test3"), cars.map { it.name })
        }

        @Test
        fun `자동차 객체들을 입력받는다`() {
            val cars = Cars(listOf(Car("test1"), Car("test2"), Car("test3")))
            assertEquals(listOf("test1", "test2", "test3"), cars.map { it.name })
        }
    }

    @Nested
    inner class `자동차들 중에서` {
        @Test
        fun `가장 멀리 간 자동차의 위치를 반환한다`() {
            val cars = Cars(listOf(Car("test1", 0), Car("test2", 2), Car("test3", 2)))
            assertEquals(2, cars.maxLocation)
        }
    }
}
