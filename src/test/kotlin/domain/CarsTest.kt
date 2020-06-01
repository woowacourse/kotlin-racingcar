package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    @DisplayName("Cars 생성")
    internal fun constructor() {
        assertThat(Cars()).isNotNull
    }

    @Test
    @DisplayName("모든 차 전진")
    internal fun move() {
        val car1 = Car(Position()) { true }
        val car2 = Car(Position()) { true }
        val car3 = Car(Position()) { true }
        val cars = Cars(listOf(car1, car2, car3))

        cars.move()

        assertThat(car1.position()).isEqualTo(1)
        assertThat(car2.position()).isEqualTo(1)
        assertThat(car3.position()).isEqualTo(1)
    }
}