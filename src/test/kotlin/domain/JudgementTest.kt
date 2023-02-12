package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JudgementTest {

    @Test
    fun `우승자 찾기`() {
        val generator = RandomNumberGenerator()
        val testValues = listOf(Pair("pobi", 4), Pair("woni", 4), Pair("jun", 2), Pair("ver", 5), Pair("glo", 5))
        val cars = testValues.map { (name, distance) -> Car(generator, name, distance) }
        val judgement = Judgement(cars)
        assertThat(judgement.findWinners().getWinners()).containsExactly("ver", "glo")
    }
}
