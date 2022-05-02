package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import vo.Name
import vo.Position

internal class CarsTest {

    @Test
    @DisplayName("position이 가장 높은 자동차가 우승한다.")
    fun decideFinalWinner() {
        val pepperCar = Car(Name("peper"), Position(1))
        val zeroCar = Car(Name("zero"), Position(2))
        val jasonCar = Car(Name("jason"), Position(3))
        val cars = Cars(listOf(pepperCar, zeroCar, jasonCar))
        val winners = cars.getWinners()

        assertThat(winners).contains(Name("jason"))
    }

    @Test
    @DisplayName("position이 가장 높은 자동차가 두 대일때 공동 우승자가 된다.")
    fun decideFinalWinners() {
        val pepperCar = Car(Name("peper"), Position(1))
        val zeroCar = Car(Name("zero"), Position(3))
        val jasonCar = Car(Name("jason"), Position(3))
        val cars = Cars(listOf(pepperCar, zeroCar, jasonCar))
        val winners = cars.getWinners()

        assertThat(winners).contains(Name("zero"), Name("jason"))
    }
}
