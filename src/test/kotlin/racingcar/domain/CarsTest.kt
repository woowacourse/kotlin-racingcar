package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `포지션이 가장 높은 자동차들을 반환한다`() {
        val 하티 = Car("하티", 5)
        val cars = Cars(listOf(하티, Car("박스터", 1)))

        val actual = cars.findWinningCars()

        assertThat(actual).containsExactly(하티)
    }
}
