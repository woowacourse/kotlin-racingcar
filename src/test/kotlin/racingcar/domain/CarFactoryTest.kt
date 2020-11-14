package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarFactoryTest {

    @Test
    fun create() {
        val carNames = listOf("pobi", "crong", "honux")
        val cars = CarFactory.create(carNames)
        assertThat(cars.size).isEqualTo(3)

        cars.forEach { assertThat(it.position).isEqualTo(Position(0)) }
        cars.forEachIndexed { index, car -> assertThat(car.name).isEqualTo(carNames[index]) }
    }
}