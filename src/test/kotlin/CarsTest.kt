import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars

class CarsTest {
    @Test
    fun `가장 멀리 간 자동차가 우승한다`() {
        val cars =
            Cars(
                listOf(
                    Car("car1", 3),
                    Car("car2", 5),
                    Car("car3", 2),
                ),
            )

        val winners = cars.getWinner()

        assertThat(winners).isEqualTo(listOf("car2"))
    }

    @Test
    fun `가장 멀리 간 자동차가 여러 대이면 여러 대가 우승한다`() {
        val cars =
            Cars(
                listOf(
                    Car("car1", 3),
                    Car("car2", 5),
                    Car("car3", 5),
                ),
            )

        val winners = cars.getWinner()

        assertThat(winners).isEqualTo(listOf("car2", "car3"))
    }
}
