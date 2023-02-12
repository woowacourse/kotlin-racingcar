package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.util.NumberGenerator

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
    fun `3대의 차량이 레이스를 끝냈을 때 결과 테스트 `() {
        val result = racingGame.race(3, testGenerator)
        assertThat(result).isEqualTo(listOf(listOf(1, 1, 1), listOf(2, 2, 2), listOf(3, 3, 3)))
    }

    private val testGenerator = object : NumberGenerator {
        override fun generate(): Int {
            return 4
        }
    }
}
