package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CarsTest{

    @Test
    internal fun race() {
        val cars = Cars(3)
        assertThat(cars.cars()).hasSize(3)
    }
}