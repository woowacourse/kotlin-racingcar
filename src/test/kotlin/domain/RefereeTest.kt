package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {

    private val referee = Referee()

    @Test
    fun `자동차들 중 가장 먼 거리에 있는 자동차가 우승자다`() {
        val car1 = Car("car1", 1)
        val car2 = Car("car2", 5)
        val car3 = Car("car3", 3)

        assertThat(referee.judgeWinners(listOf(car1, car2, car3))).isEqualTo(listOf("car2"))
    }
}
