package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.NumberGenerator
import racingcar.domain.RaceManager
import racingcar.racingcar.domain.RaceResultDto
import racingcar.racingcar.view.InputInterface
import racingcar.racingcar.view.OutputInterface

class GameControllerTest {
    @Test
    fun `runGame 함수를 통한 최종 우승자 정상 출력 확인`() {
        val gameController =
            GameController(RaceManager(TestNumberGenerator(mutableListOf(1, 2, 4))), TestInputViewInterface(), TestOutputViewInterface())
        gameController.runGame()
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
            return numbers.removeAt(0)
        }
    }

    class TestInputViewInterface : InputInterface {
        override fun inputCarNames(): List<String> {
            return listOf("test1", "test2", "test3")
        }

        override fun inputRacingCount(): Int {
            return 1
        }
    }

    class TestOutputViewInterface : OutputInterface {
        override fun printRaceResult(raceResultDto: RaceResultDto) {
        }

        override fun printCarsState(names: List<String>, locations: List<Int>) {
        }

        override fun printCarState(name: String, location: Int) {
        }

        override fun printWinner(names: List<String>) {
            assertThat(names).isEqualTo(listOf("test3"))
        }
    }
}
