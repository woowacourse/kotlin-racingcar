package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.name.Name
import java.lang.IllegalArgumentException

internal class CarsTest {
    private val car1 = Car(Name("pobi"))
    private val car2 = Car(Name("corgi"))
    private val car3 = Car(Name("mario"))
    private val cars = Cars(listOf(car1, car2, car3))

    @DisplayName("우승자를 찾는다.")
    @Test
    fun findWinnerTest() {
        car1.tryToMove(5)

        val winners = cars.findWinners()
        assertThat(winners.cars()).isEqualTo(listOf(car1))
    }

    @DisplayName("우승자를 찾는다. :: 우승자가 여러 명일 경우")
    @Test
    fun findMultipleWinnerTest() {
        car1.tryToMove(5)
        car2.tryToMove(5)

        val winners = cars.findWinners()
        assertThat(winners.cars()).isEqualTo(listOf(car1, car2))
    }

    @DisplayName("중복 이름이 존재할 경우 에러가 발생한다.")
    @Test
    fun carsWithDuplicatedNames() {
        val car1 = Car(Name("pobi"))
        val car2 = Car(Name("pobi"))

        assertThatThrownBy {
            Cars(listOf(car1, car2))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}