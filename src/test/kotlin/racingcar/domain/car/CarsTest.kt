package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarsTest{

    @DisplayName("우승자를 찾는다.")
    @Test
    fun findWinnerTest(){
        val car1 = Car("pobi")
        val car2 = Car("corgi")
        val car3 = Car("mario")

        car1.tryToMove(5)

        val cars = Cars(listOf(car1, car2, car3))
        val winners = cars.findWinners()

        assertThat(winners.cars()).isEqualTo(listOf(car1))
    }

    @DisplayName("우승자를 찾는다. :: 우승자가 여러 명일 경우")
    @Test
    fun findMultipleWinnerTest(){
        val car1 = Car("pobi")
        val car2 = Car("corgi")
        val car3 = Car("mario")

        car1.tryToMove(5)
        car2.tryToMove(5)

        val cars = Cars(listOf(car1, car2, car3))
        val winners = cars.findWinners()

        assertThat(winners.cars()).isEqualTo(listOf(car1, car2))
    }
}