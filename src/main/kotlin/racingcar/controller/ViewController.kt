package racingcar.controller

import racingcar.model.Car
import racingcar.utils.MAX_ROUND_COUNT
import racingcar.utils.MIN_ROUND_COUNT
import racingcar.utils.RacingRuleValidator
import racingcar.utils.TEXT_IN_LINE_DELIMITER
import racingcar.utils.TextUtils.removeTextsBlank
import racingcar.view.InputView
import racingcar.view.OutputView

class ViewController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    private val racingRule = RacingRuleValidator()

    fun readCarNames(): List<String> {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        val input = inputView.readCarNames()
        val carNames = removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

        require(racingRule.isValidateNotDuplicatedCarNames(carNames)) { DUPLICATED_CAR_NAME_ERROR_MESSAGE }

        return carNames
    }

    fun readRoundCount(): Int {
        outputView.printMessage(ROUND_COUNT_REQUEST_MESSAGE)
        val input = inputView.readRoundCount()

        require(input.toIntOrNull() != null) { NOT_INTEGER_TYPE_ERROR_MESSAGE }
        require(racingRule.isValidateRoundCountBoundary(input.toInt())) { ROUND_COUNT_BOUNDARY_ERROR_MESSAGE }

        return input.toInt()
    }

    fun printRunResult() {
        outputView.printMessage(ROUNDS_RESULT_NOTIFICATION_MESSAGE)
    }

    fun printRoundResult(cars: List<Car>) = outputView.printRoundResult(cars)

    fun printWinners(winners: List<Car>) {
        outputView.printMessage("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ")}")
    }

    companion object {
        private const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
        private const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"

        private const val DUPLICATED_CAR_NAME_ERROR_MESSAGE = "자동차 이름 중복 빼주세요~"

        private const val NOT_INTEGER_TYPE_ERROR_MESSAGE = "시도 횟수는 숫자 형태로 부탁이요~"
        private const val ROUND_COUNT_BOUNDARY_ERROR_MESSAGE = "시도 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"
    }
}
