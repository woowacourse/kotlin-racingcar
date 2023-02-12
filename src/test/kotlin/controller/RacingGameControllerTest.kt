package controller

import model.Car
import model.Name
import model.TryCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import service.NumberGenerator
import service.RacingCarGameService
import validation.NameValidation
import validation.NameValidationResult
import validation.TryCountValidation
import validation.TryCountValidationResult
import view.InputView
import view.OutputView

class RacingGameControllerTest {

    val inputView = InputView()
    val outputView = OutputView()
    val nameValidation = NameValidation()
    val tryCountValidation = TryCountValidation()
    val numberGenerator: NumberGenerator = TestNumberGenerator(listOf(5, 6, 3))
    val racingGameController = RacingGameController(inputView, outputView, RacingCarGameService(numberGenerator))

    @Test
    fun `k5을 입력하였을때, Name("K5") 객체를 반환한다 `() {
        val result = nameValidation.checkNames("k5")
        val actual = racingGameController.checkCarNamesInput(result)
        assertThat(actual).isEqualTo(Name("k5"))
    }

    @Test
    fun `avantae 를 입력하을때, 이름 길이 에러 메세지를 출력하고 null을 반환한다`() {
        var result = nameValidation.checkNames("avantae")
        result = result as NameValidationResult.Failure
        assertThat(result.errorMessage).isEqualTo(NameValidation.NAME_RANGE_ERROR_MASSAGE)
        val actual = racingGameController.checkCarNamesInput(result)
        assertThat(actual).isEqualTo(null)
    }

    @Test
    fun `0을 입력하였을 때, 양수 에러 메세지를 출력하고 null을 반환한다`() {
        var result = tryCountValidation.checkTryCount("0")
        result = result as TryCountValidationResult.Failure
        assertThat(result.errorMessage).isEqualTo(TryCountValidation.TRY_COUNT_POSITIVE_ERROR_MESSAGE)
        val actual = racingGameController.checkTryCountInput(result)
        assertThat(actual).isEqualTo(null)
    }

    @Test
    fun `3을 입력하였을 때, TryCount("3") 객체를 반환한다 `() {
        val result = tryCountValidation.checkTryCount("3")
        val actual = racingGameController.checkTryCountInput(result)
        assertThat(actual).isEqualTo(TryCount("3"))
    }

    @Test
    fun `차량이 3대이고, 랜덤 숫자가 5,6,3 일때  앞의 두 차량만 1번 움직인 상태를 출력한다`() {
        val carA = Car("aa", 0)
        val carB = Car("bb", 0)
        val carC = Car("cc", 0)
        val carsInfo = listOf(carA, carB, carC)
        val actual = racingGameController.playRound(carsInfo)
        val expect = "aa : -\nbb : -\ncc : \n"
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `시도횟수가 3번이고, 차량이 3대이고, 시도 할때마다 랜덤 숫자가 5,6,3 이 반복될 때,  앞의 두 차량만 3번 움직인 상태를 출력한다`() {
        val numberGenerator = TestNumberGenerator(listOf(5, 6, 3, 5, 6, 3, 5, 6, 3))
        val racingGameController = RacingGameController(inputView, outputView, RacingCarGameService(numberGenerator))
        val carA = Car("aa", 0)
        val carB = Car("bb", 0)
        val carC = Car("cc", 0)
        val carsInfo = listOf(carA, carB, carC)
        val actual = racingGameController.playWholeRound(3, carsInfo)
        val expect = "aa : -\nbb : -\ncc : \n\n" +
            "aa : --\n" +
            "bb : --\n" +
            "cc : \n\n" +
            "aa : ---\n" +
            "bb : ---\n" +
            "cc : \n\n"
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `시도횟수가 3번이고, 차량이 3대이고, 랜덤 숫자가 5,6,3 이 반복될 때,  우승자는 앞 두차량이다`() {
        val numberGenerator = TestNumberGenerator(listOf(5, 6, 3, 5, 6, 3, 5, 6, 3))
        val racingGameController = RacingGameController(inputView, outputView, RacingCarGameService(numberGenerator))
        val carA = Car("aa", 0)
        val carB = Car("bb", 0)
        val carC = Car("cc", 0)
        val carsInfo = listOf(carA, carB, carC)
        racingGameController.playWholeRound(3, carsInfo)
        val actual = racingGameController.gerWinner(carsInfo)
        val expect = listOf("aa", "bb")
        assertThat(actual).isEqualTo(expect)
    }

    class TestNumberGenerator(numbers: List<Int>) : NumberGenerator {
        private val numbers: MutableList<Int> = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}
