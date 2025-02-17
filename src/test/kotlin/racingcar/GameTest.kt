package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Game
import racingcar.model.RandomNumberFactory

class GameTest {
    private lateinit var randomNumberFactory: FakeRandomNumberFactory
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        randomNumberFactory = FakeRandomNumberFactory()
        cars = listOf(Car("peto"), Car("por"))
    }

    fun `getRoundResult - 게임 중간 라운드 결과를 출력한다`() {
        val game = Game(cars, randomNumberFactory.movableRandomNumberFactory())

        game.playRound()

        val result = game.getRoundResult()

        val expected = "peto : -\npor : -"

        assertEquals(expected, result)
    }

    @Test
    fun `getWinners - 게임 최종 우승자를 출력한다`() {
        val game = Game(cars, randomNumberFactory.movableRandomNumberFactory())

        game.playRound()

        val result = game.getWinners()

        val expected = "peto, por"

        assertEquals(expected, result)
    }

    @Test
    fun `validateUniqueName - 자동차 이름이 중복되면 예외가 발생해야 한다`() {
        val duplicatedCars = listOf(Car("pobi"), Car("pobi"))

        Assertions.assertThatThrownBy {
            Game(duplicatedCars, RandomNumberFactory { 0 })
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 자동차 이름이 중복됩니다.")
    }
}
