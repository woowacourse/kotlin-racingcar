package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun go() {
        val car = Car("a");
        val initialPosition = car.position
        car.go(4)

        assertThat(car.position).isEqualTo(initialPosition.plus())

        car.go(3)

        assertThat(car.position).isEqualTo(initialPosition.plus())
    }
}