package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `우승한 자동차들을 반환한다`() {
        val 하티 = Car.from("하티")
        val cars = Cars(listOf(하티, Car.from("박스터")))

        cars.moveAll(TestNumberGenerator(mutableListOf(10, 0)))

        val actual = cars.findWinningCars()

        assertThat(actual).containsExactly(하티)
    }
}
