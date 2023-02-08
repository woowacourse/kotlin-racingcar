package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingManagerTest {
    @Test
    fun determineWinner() {
        val racingManager = RacingManager()

        racingManager.initCars(listOf("test1", "test2", "test3"))

        racingManager.processStep(0, 3)
        racingManager.processStep(1, 1)
        racingManager.processStep(2, 7)
        racingManager.processStep(0, 1)
        racingManager.processStep(1, 5)
        racingManager.processStep(2, 6)

        val winners = racingManager.determineWinner()
        assertThat(winners[0].getName()).isEqualTo("test3")
    }
}
