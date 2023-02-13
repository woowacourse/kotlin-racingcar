package domain

import common.ERROR_MESSAGE_FORMAT
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GameCarsTest {

    @Nested
    inner class `생성할 때` {

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class `자동차의 개수가 2 이상 20 이하가 아니라면` {

            @ParameterizedTest
            @MethodSource("getIllegalSizeCars")
            fun `예외 메세지를 포함한 IllegalArgumentException을 던진다`(cars: Set<Car>) {
                assertThatIllegalArgumentException().isThrownBy { GameCars(cars) }
                    .withMessageContaining(ERROR_MESSAGE_FORMAT.format("자동차는 최소 2대에서 최대 20대 사이여야 합니다."))
            }

            private fun getIllegalSizeCars() = listOf(
                Arguments.of(setOf(Car("pobi", RandomMovingStrategy()))),
                Arguments.of((1..21).map { Car("pobi".plus('a' + it), RandomMovingStrategy()) }.toSet())
            )
        }

        @Nested
        inner class `중복되지 않은 2대 이상 20대 이하의 자동차가 주어지면` {

            @Test
            fun `예외를 던지지 않는다`() {
                val cars = getCars()

                assertThatCode { GameCars(cars) }.doesNotThrowAnyException()
            }
        }
    }

    @Test
    fun `게임 내의 모든 자동차를 움직이려 하면 모든 자동차들이 전략대로 움직인다`() {
        val cars = getCars()
        val gameCars = GameCars(cars)

        gameCars.advanceAllCars()

        assertThat(cars.map { it.advancedCount }).isEqualTo(listOf(1, 1, 1))
    }

    private fun getCars(): Set<Car> = setOf(
        Car("pobi", OnlyAdvanceMovingStrategy()),
        Car("tom", OnlyAdvanceMovingStrategy()),
        Car("tony", OnlyAdvanceMovingStrategy())
    )

    @Test
    fun `getMostAdvancedCars 메소드를 실행하면 가장 전진 횟수가 많은 자동차들을 반환한다`() {
        val cars = getAdvancedCars()
        val gameCars = GameCars(cars)

        val winCars = gameCars.getMostAdvancedCars()

        assertThat(winCars.map { it.name }).isEqualTo(listOf("tom", "tony"))
    }

    private fun getAdvancedCars(): Set<Car> {
        val cars = setOf(
            Car("pobi", OnlyAdvanceMovingStrategy()),
            Car("tom", OnlyAdvanceMovingStrategy()),
            Car("tony", OnlyAdvanceMovingStrategy())
        )

        cars.first { it.name == "pobi" }.moveAccordingToStrategy()
        repeat(3) { cars.first { it.name == "tom" }.moveAccordingToStrategy() }
        repeat(3) { cars.first { it.name == "tony" }.moveAccordingToStrategy() }

        return cars
    }

    private class OnlyAdvanceMovingStrategy() : MovingStrategy {
        override fun isMovable(): Boolean = true
    }
}
