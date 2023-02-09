package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CarRacingGameManagerTest {

    @Nested
    inner class `allCarsTryToMoveForward 메소드는` {
        @Nested
        inner class `첫 번째와 세 번째 차만 전진을 한다면` {
            private val cars: List<Car> = listOf(Car("pobi"), Car("mendl"), Car("thom"))
            private val gameManager = CarRacingGameManager(cars, FakeMovingStrategy())

            @Test
            fun `첫 번째 차와 세 번째 차의 전진 횟수만 1이 된다`() {
                gameManager.allCarsTryToMoveForward()
                val result = cars.map { it.advanceCount }
                val expected = listOf(1, 0, 1)
                assertThat(result).isEqualTo(expected)
            }

            inner class FakeMovingStrategy : MovingStrategy {
                private val pattern = listOf(true, false, true)
                private var i = 0
                override fun isMovable(): Boolean = pattern[i++]
            }
        }
    }

    @Nested
    inner class `getWinCars 메소드는` {

        @Nested
        inner class `자동차들을 받으면` {
            private val cars: List<Car> = getCars()
            private val gameManager = CarRacingGameManager(cars, RandomMovingStrategy())

            @Test
            fun `전진 횟수가 가장 많은 자동차들을 반환한다`() {
                val winCars = gameManager.getWinCars()

                assertThat(winCars).containsOnly(cars[2])
            }

            private fun getCars(): List<Car> {
                val cars = listOf(Car("1"), Car("2"), Car("3"))
                cars.forEach { car -> repeat(car.name.toInt()) { car.move() } }
                return cars
            }
        }
    }
}
