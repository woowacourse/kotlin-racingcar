package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarsTest {

    @DisplayName("우승자를 가져오는 테스트")
    @Test
    fun winnerTest() {
        //  given
        val cars = Cars(
            listOf(
                Car(Name("파워"), FixedNumberGenerator(4)),
                Car(Name("블랙캣"), FixedNumberGenerator(2)),
                Car(Name("망고"), FixedNumberGenerator(7))
            )
        )

        //  when
        cars.moveAll()

        //  then
        assertThat(cars.getWinner()).contains(Name("파워"), Name("망고"))
    }
}
