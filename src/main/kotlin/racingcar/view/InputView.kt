package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.utils.MAX_ROUND_COUNT
import racingcar.utils.MIN_ROUND_COUNT
import racingcar.utils.RacingRuleValidator
import racingcar.utils.TEXT_IN_LINE_DELIMITER

class InputView() {

    fun readCars(): Cars {
        println(REQUEST_MESSAGE_CAR_NAMES)
        val carNames = readCarNames()
        return Cars(carNames.map { Car(it) })
    }

    fun readRoundCount(): Int {
        println(REQUEST_MESSAGE_ROUND_COUNT)
        val input = readln()
        val racingRule = RacingRuleValidator()

        require(input.toIntOrNull() != null) { ERROR_MESSAGE_NOT_INTEGER_TYPE }
        require(racingRule.isValidateRoundCountBoundary(input.toInt())) { ERROR_MESSAGE_ROUND_COUNT_BOUNDARY }

        return input.toInt()
    }

    private fun readCarNames(): List<String> {
        val input = readln()
        return input
            .split(TEXT_IN_LINE_DELIMITER)
            .map { it.trim() }
    }

    companion object {
        private const val REQUEST_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val REQUEST_MESSAGE_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

        private const val ERROR_MESSAGE_NOT_INTEGER_TYPE = "시도 횟수는 숫자 형태로 부탁이요~"
        private const val ERROR_MESSAGE_ROUND_COUNT_BOUNDARY = "시도 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"
    }
}
