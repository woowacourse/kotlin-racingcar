package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingManagerTest {
    @Test
    fun initCars() {
        val racingManager = RacingManager()

        assertThrows<IllegalArgumentException> {
            racingManager.initCars(listOf())
        }
    }

    @Test
    fun setAttemptCount() {
        val racingManager = RacingManager()

        assertThrows<IllegalArgumentException> {
            racingManager.setAttemptCount(0)
        }
    }

    @Test
    fun determineWinner() {
        val racingManager = RacingManager()

        racingManager.initCars(listOf("test1", "test2", "test3"))

        racingManager.step(0, 3)
        racingManager.step(1, 1)
        racingManager.step(2, 7)
        racingManager.step(0, 1)
        racingManager.step(1, 5)
        racingManager.step(2, 6)

        val winners = racingManager.determineWinner()
        assertThat(winners[0].getName()).isEqualTo("test3")
    }

    @Test
    fun step() {
        val racingManager = RacingManager()
        racingManager.initCars(listOf("test1", "test2"))

        assertThrows<IllegalArgumentException> {
            racingManager.step(0, -1)
            racingManager.step(1, 10)
        }
    }
}
