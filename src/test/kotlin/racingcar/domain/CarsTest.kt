package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun create() {
        val cars = Cars(3)
        assertThat(cars.cars()).hasSize(3)
    }

    @Test
    internal fun race() {
        val betterCar = Car { true }
        val aaronCar = Car { false }

        val cars = Cars(arrayListOf(betterCar, aaronCar))
        cars.race()

        assertThat(betterCar.isSamePosition(1)).isTrue()
        assertThat(aaronCar.isSamePosition(0)).isTrue()
    }
}
