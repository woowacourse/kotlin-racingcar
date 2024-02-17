package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.random.RacingCarRandomNumber

class RacingCarGameTest {
    private lateinit var racingCarGame: RacingCarGame
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = listOf(Car("eddy"), Car("yenny"), Car("hodu"), Car("leo"))
        racingCarGame = RacingCarGame(cars, RacingCarRandomNumber)
    }

    @Test
    fun `무작위 값이 4인 경우, 자동차는 한 칸 전진한다`() {
        // given
        val randomNumber = 4

        // when
        racingCarGame.move(0, randomNumber)

        // then
        assertThat(cars[0].distance).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 3인 경우, 자동차는 한칸 전진하지 못한다`() {
        // given
        val randomNumber = 3
        // when
        racingCarGame.move(0, randomNumber)

        // then
        assertThat(cars[0].distance).isEqualTo(0)
    }

    @Test
    fun `예니 자동차가 두번 전진했을 경우, 예니가 우승자가 된다`() {
        // given
        val carIndex = 1

        // when
        repeat(2) {
            racingCarGame.move(carIndex, 4)
        }

        // then
        assertThat(racingCarGame.findWinners().first().name).isEqualTo("yenny")
    }

    @Test
    fun `에디와 예니가 두번 전진했을 경우, 우승자느 에디와 예니이다`() {
        // given
        val eddyCarIndex = 0
        val yennyCarIndex = 1

        // when
        repeat(2) {
            racingCarGame.move(eddyCarIndex, 4)
            racingCarGame.move(yennyCarIndex, 4)
        }

        // then
        assertThat(racingCarGame.findWinners().joinToString { it.name }).isEqualTo("eddy, yenny")
    }

    @Test
    fun `에디 외 나머지가 한번씩 전진했을 때, 우승자는 에디가 아니다`() {
        // given
        val eddyCarIndex = 0
        val yennyCarIndex = 1
        val hoduCarIndex = 2
        val leoCarIndex = 3

        //
        // when
        racingCarGame.move(eddyCarIndex, 3) // 전진 실패
        racingCarGame.move(yennyCarIndex, 4)
        racingCarGame.move(hoduCarIndex, 4)
        racingCarGame.move(leoCarIndex, 4)

        // then
        assertThat(racingCarGame.findWinners().joinToString { it.name }).isNotEqualTo("eddy")
    }
}
