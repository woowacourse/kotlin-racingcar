package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.enums.MoveState
import racingcar.model.Car
import racingcar.model.Game
import racingcar.model.RoundResult
import racingcar.model.random.RandomNumberGenerator
import racingcar.model.random.RandomNumberGeneratorImpl

class GameTest {
    private lateinit var moveAbleRandomNumberGenerator: RandomNumberGenerator
    private lateinit var unMoveAbleRandomNumberGenerator: RandomNumberGenerator
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        moveAbleRandomNumberGenerator = RandomNumberGeneratorImpl(MOVEABLE_RANGE_MIN, MOVEABLE_RANGE_MAX)
        unMoveAbleRandomNumberGenerator = RandomNumberGeneratorImpl(UNMOVEABLE_RANGE_MIN, UNMOVEABLE_RANGE_MAX)
        cars = listOf(Car("peto"), Car("por"))
    }

    @Test
    fun `랜덤 숫자가 4미만 이여서 이동할 수 없을 때 게임 중간 라운드 결과를 출력한다`() {
        val game = Game(cars, unMoveAbleRandomNumberGenerator)

        game.playRound()

        val result = game.getRoundResult()

        val expected = listOf<RoundResult>(RoundResult("peto", 0), RoundResult("por", 0))

        assertEquals(expected, result)
    }

    @Test
    fun `랜덤 숫자가 4이상 이여서 이동할 수 있을 때 게임 중간 라운드 결과를 출력한다`() {
        val game = Game(cars, moveAbleRandomNumberGenerator)

        game.playRound()

        val result = game.getRoundResult()

        val expected = listOf<RoundResult>(RoundResult("peto", 1), RoundResult("por", 1))

        assertEquals(expected, result)
    }

    @Test
    fun `최종 우승자는 1칸 이동한 peto다`() {
        val cars: List<Car> = listOf(Car("Peto"), Car("Por"), Car("nana"))
        cars.first().moveCarWhenMovable(MoveState.MOVABLE)

        val game = Game(cars, moveAbleRandomNumberGenerator)
        val result = game.getWinners()

        val expected = listOf("Peto")

        assertEquals(expected, result)
    }

    @Test
    fun `자동차 이름이 중복되면 예외가 발생해야 한다`() {
        val duplicatedCars = listOf(Car("pobi"), Car("pobi"))

        Assertions.assertThatThrownBy {
            Game(duplicatedCars, moveAbleRandomNumberGenerator)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 자동차 이름이 중복됩니다.")
    }

    companion object {
        const val UNMOVEABLE_RANGE_MIN = 0
        const val UNMOVEABLE_RANGE_MAX = 3

        const val MOVEABLE_RANGE_MIN = 4
        const val MOVEABLE_RANGE_MAX = 9
    }
}
