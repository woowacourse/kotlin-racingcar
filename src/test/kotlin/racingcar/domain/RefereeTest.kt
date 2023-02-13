package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RefereeTest {
    private val referee = Referee()

    @Test
    fun `우승자 찾기`() {
        val cars = listOf(
            RacingCar("one", 3),
            RacingCar("two", 2),
            RacingCar("three", 3),
        )
        Assertions.assertThat(
            referee.getWinner(cars),
        ).contains("one", "three").doesNotContain("two")
    }
}
