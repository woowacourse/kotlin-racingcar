package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {
    lateinit var racingGame: RacingGame
    @BeforeEach
    fun setup(){
        racingGame = RacingGame(mutableListOf(Car("A"), Car("B")))
    }
    @RepeatedTest(100)
    fun `랜덤넘버 리스트의 요소가 전부 제한 범위 내인지`() {
        val result = racingGame.generateRandomNumber()
        assertThat(result).isIn(0..9)
    }
}
