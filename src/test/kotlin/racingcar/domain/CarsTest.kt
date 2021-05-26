package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun create() {
        val cars = Cars(6)
        assertThat(cars.cars()).hasSize(6)
    }

    @Test
    internal fun race() {
        val moveStrategy: MoveStrategy = object : MoveStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        }
        val stopStrategy: MoveStrategy = object : MoveStrategy {
            override fun isMovable(): Boolean {
                return false
            }
        }
        val betterCar = Car(moveStrategy)
        val aaronCar = Car(stopStrategy)

        val cars = Cars(arrayListOf(betterCar, aaronCar))
        cars.race()

        assertThat(betterCar.isSamePosition(1)).isTrue()
        assertThat(aaronCar.isSamePosition(0)).isTrue()
    }


}