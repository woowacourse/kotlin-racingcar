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

    @Test
    fun attempt() {
        val racingManager = RacingManager()
        racingManager.initCars(listOf("test1", "test2"))

        racingManager.step(0, 2)
        racingManager.step(1, 7)

        assertThat(racingManager.makeAttemptLog()).isEqualTo("test1 : \ntest2 : -")
    }

    @Test
    fun run() {
        val racingManager = RacingManager()
        racingManager.initCars(listOf("test1", "test2"))

        val result = mutableListOf<String>()

        racingManager.step(0, 2)
        racingManager.step(1, 7)

        result.add(racingManager.makeAttemptLog())

        racingManager.step(0, 9)
        racingManager.step(1, 5)

        result.add(racingManager.makeAttemptLog())

        assertThat(racingManager.makeRunLog(result)).isEqualTo("test1 : \ntest2 : -\n\ntest1 : -\ntest2 : --")
    }
}
