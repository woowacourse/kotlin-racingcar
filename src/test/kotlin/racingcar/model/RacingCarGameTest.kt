package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingCarGameTest {
    private lateinit var racingCarGame: RacingCarGame
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = listOf(Car("eddy"), Car("yenny"), Car("hodu"), Car("leo"))
        racingCarGame = RacingCarGame(cars)
    }

    @Test
    fun `자동차 이동 로직 테스트 - 성공`() {
        racingCarGame.move(0, 4)
        assertThat(cars[0].distance).isEqualTo(1)
    }

    @Test
    fun `자동차 이동 로직 테스트 - 이동 멈춤`() {
        racingCarGame.move(0, 3)
        assertThat(cars[0].distance).isEqualTo(0)
    }

    @Test
    fun `자동차 우승 찾기 테스트 - 예니 1등`() {
        racingCarGame.move(1, 4)
        racingCarGame.move(1, 4)

        assertThat(racingCarGame.findWinners().first().name).isEqualTo("yenny")
    }
}
