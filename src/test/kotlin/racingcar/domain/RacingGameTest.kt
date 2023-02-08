package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    val racingGame = RacingGame()

    @Test
    fun `전진하는 경우`() {
        assertThat(
            racingGame.checkGoingForward(4),
        ).isTrue
    }

    @Test
    fun `전진하지 않는 경우`() {
        assertThat(
            racingGame.checkGoingForward(3),
        ).isFalse
    }
}
