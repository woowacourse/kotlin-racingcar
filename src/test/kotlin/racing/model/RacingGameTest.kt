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

    @Test
    fun `랜덤 값의 범위가 0에서 9사이인지 확인`() {
        val randomNumbers = racingGame.createRandomNumbers(3)
        assertThat(randomNumbers.count { it in 0..9 }).isEqualTo(3)
    }

    @Test
    fun moveCars() {
        racingGame.moveCars(listOf(4, 3, 8))
        val cars = racingGame.getCars().map { it.getPosition() }
        val expectation = listOf(1, 0, 1)
        assertThat(cars).isEqualTo(expectation)
    }

    @Test
    fun `우승자가 한명일 때`() {
        racingGame.moveCars(listOf(2, 3, 4))
        assertThat(racingGame.getWinners()).isEqualTo(listOf("jason"))
    }

    @Test
    fun `우승자가 여러명일 때`() {
        racingGame.moveCars(listOf(1, 4, 4))
        assertThat(racingGame.getWinners()).isEqualTo(listOf("pobi", "jason"))
    }
}