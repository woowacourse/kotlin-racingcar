package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    private val racingGame = RacingGame()

    @BeforeEach
    fun setUp() {
        racingGame.initRacing(listOf(Car("woni"), Car("pobi"), Car("jason")))
    }

    @Test
    fun `getCars()로 반환이 되는지 확인`() {
        val cars = racingGame.getCars().map { it.getName() }
        val expectation = listOf(Car("woni"), Car("pobi"), Car("jason")).map { it.getName() }
        assertThat(cars).isEqualTo(expectation)
    }
}
