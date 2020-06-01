package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTest {
    @Test
    @DisplayName("자동차 생성")
    internal fun constructor() {
        assertThat(Car(Position()) { true }).isNotNull
    }

    @Test
    @DisplayName("자동차 이동")
    internal fun move() {
        val car = Car(Position()) { true }
        val startPosition = car.position()
        car.move()

        assertThat(car.position()).isEqualTo(startPosition + 1)
    }
}