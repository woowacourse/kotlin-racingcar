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
    fun `자동차 경주 한 라운드 실행 - hodu, leo만 한 칸 전진`() {
        val numbers = mutableListOf(2, 3, 4, 5)
        val result = racingCarGame.race { numbers.removeAt(0) }
        val expected = listOf(Car("eddy"), Car("yenny"), Car("hodu", 1), Car("leo", 1))
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `무작위 값이 4 이상일 경우 - 해당 자동차 한 칸 전진`() {
        racingCarGame.move(0, 4)
        assertThat(cars[0].distance).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4 미만일 경우 - 해당 자동차는 움직이지 않는다`() {
        racingCarGame.move(0, 3)
        assertThat(cars[0].distance).isEqualTo(0)
    }

    @Test
    fun `자동차 우승자가 한 명일 경우 - 예니 1등`() {
        racingCarGame.move(1, 4)
        racingCarGame.move(1, 4)

        val expected = listOf(Car("yenny", 2))
        assertThat(racingCarGame.findWinners()).isEqualTo(expected)
    }

    @Test
    fun `자동차 우승자가 여러 명일 경우 (2명) - 예니,에디 1등`() {
        racingCarGame.move(0, 5)
        racingCarGame.move(0, 5)
        racingCarGame.move(1, 4)
        racingCarGame.move(1, 4)

        val actual = racingCarGame.findWinners()
        val expected = listOf(Car("eddy", 2), Car("yenny", 2))
        assertThat(actual.size).isEqualTo(2)
        assertThat(actual).isEqualTo(expected)
    }
}
