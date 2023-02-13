package racingcar.controller

import racingcar.utils.MAX_ROUND_COUNT
import racingcar.utils.MIN_ROUND_COUNT
import racingcar.utils.RacingRuleValidator
import racingcar.utils.TEXT_IN_LINE_DELIMITER
import racingcar.utils.TextUtils
import racingcar.view.InputView
import racingcar.view.OutputView

class InputController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val racingRule: RacingRuleValidator = RacingRuleValidator()
) {

    fun readCarNames(): List<String> {
        outputView.printMessage(CAR_NAMES_REQUEST_MESSAGE)
        val input = inputView.readCarNames()
        val carNames = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

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

    companion object {
        const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"

        const val DUPLICATED_CAR_NAME_ERROR_MESSAGE = "자동차 이름 중복 빼주세요~"
        const val NOT_INTEGER_TYPE_ERROR_MESSAGE = "시도 횟수는 숫자 형태로 부탁이요~"
        const val ROUND_COUNT_BOUNDARY_ERROR_MESSAGE = "시도 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"
    }
}
