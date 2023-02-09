package domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CarRacingGameManagerTest {

    @Nested
    inner class `getWinCars 메소드는` {

        @Nested
        inner class `자동차들을 받으면` {
            private val cars: List<Car> = getCars()
            private val gameManager = CarRacingGameManager(cars, RandomMovingStrategy())

            @Test
            fun `전진 횟수가 가장 많은 자동차들을 반환한다`() {
                val winCars = gameManager.getWinCars()

                Assertions.assertThat(winCars).containsOnly(cars[2])
            }

            private fun getCars(): List<Car> {
                val cars = listOf(Car("1"), Car("2"), Car("3"))
                cars.forEach { car -> repeat(car.name.toInt()) { car.move() } }
                return cars
            }
        }
    }
}
