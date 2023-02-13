package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JudgmentTest {

    private val judgment = Judgment()

    @Test
    fun `우승자를 찾는다`() {
        val car1 = Car("a", 3)
        val car2 = Car("b", 5)
        val car3 = Car("c", 2)

        assertThat(judgment.findWinners(listOf(car1, car2, car3))).isEqualTo(listOf("b"))
    }
}
