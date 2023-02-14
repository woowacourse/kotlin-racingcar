package controller

import model.Name
import model.TryCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import service.NumberGenerator
import service.RacingCarGameService
import view.InputViewInterface
import view.OutputViewInterface

class RacingGameControllerTest {

    @Test
    fun `시도횟수가 3번이고, 차량이 3대이고, 시도 할때마다 랜덤 숫자가 5,6,3 이 반복될 때, 앞의 두 차량만 3번 움직인 상태를 출력한다 `() {
        val numberGenerator = TestNumberGenerator(listOf(5, 6, 3, 5, 6, 3, 5, 6, 3))
        val expect = listOf("aa", "bb")
        val racingGameController =
            RacingGameController(
                TestInputView(),
                TestOutputView { assertThat(it).isEqualTo(expect) },
                RacingCarGameService(numberGenerator)
            )
        racingGameController.run()
    }

    class TestNumberGenerator(numbers: List<Int>) : NumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }

    class TestInputView() : InputViewInterface {
        override fun inputName(): Name {
            return Name("aa,bb,cc")
        }

        override fun inputTryCount(): TryCount {
            return TryCount("3")
        }
    }

    class TestOutputView(val assertWinner: (List<String>) -> Unit) : OutputViewInterface {
        override fun printRoundResult(roundResult: String) {
            val acutal = roundResult
            val expect = "aa : -\n" +
                "bb : -\n" +
                "cc : \n\n" +
                "aa : --\n" +
                "bb : --\n" +
                "cc : \n\n" +
                "aa : ---\n" +
                "bb : ---\n" +
                "cc : \n\n"
            assertThat(acutal).isEqualTo(expect)
        }

        override fun printWinner(winners: List<String>) {
            assertWinner(winners)
        }

        override fun printRunResultMessage() {
        }

        override fun printErrorMessage(error: String) {
        }
    }
}
