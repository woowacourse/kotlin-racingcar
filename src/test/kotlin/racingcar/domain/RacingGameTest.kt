package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.numbergenerator.StubNumberGenerator

class RacingGameTest {
    private val generator = StubNumberGenerator(mutableListOf(5, 3, 5))
    private val referee = Referee()
    private val racingGame = RacingGame(generator, referee)

    @Test
    fun `숫자 4를 받았을때 전진하는지 확인하는 테스트(4부터 9까지 전진)`() {
        assertThat(
            racingGame.checkGoingForward(4),
        ).isTrue
    }

    @Test
    fun `숫자 3을 받았을때 전진하지 않는지 확인하는 테스트(0부터 3까지 전진하지 않음)`() {
        assertThat(
            racingGame.checkGoingForward(3),
        ).isFalse
    }

    @Test
    fun `play 함수 2회 전진 1회 정지 경우의수 검증`() {
        val car = RacingCar("name")
        for (i in 0..2) {
            racingGame.play(car)
        }
        assertEquals(
            2,
            car.movingState,
        )
    }

    @Test
    fun `우승자 찾기`() {
        val cars = listOf(
            RacingCar("one", 3),
            RacingCar("two", 2),
            RacingCar("three", 3),
        )
        assertThat(
            referee.getWinner(cars),
        ).contains("one", "three").doesNotContain("two")
    }
}
