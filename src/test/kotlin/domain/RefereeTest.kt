package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {

    private val referee = Referee()

    @Test
    fun `우승자를 판단한다`() {
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")

        car1.tryMove(TestNumberGenerator(3).generate())
        car2.tryMove(TestNumberGenerator(7).generate())
        car3.tryMove(TestNumberGenerator(1).generate())

        assertThat(referee.judgeWinners(listOf(car1, car2, car3))).isEqualTo(listOf("car2"))
    }
}
