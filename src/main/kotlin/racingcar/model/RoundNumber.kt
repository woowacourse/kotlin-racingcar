package racingcar.model

import racingcar.controller.Race

class RoundNumber(roundNumber: String) {
    init {
        require(roundNumber.isNotEmpty()) { Race.ERROR_REQUEST_INPUT }
        require(checkNumberOnly(roundNumber)) { ERROR_INPUT_NUMBER_ONLY }
        require(roundNumber.toInt() >= MIN_ROUND_NUMBER) { ERROR_ROUND_LESS_THAN_ONE }
    }

    private fun checkNumberOnly(roundNumber: String): Boolean {
        return roundNumber.toIntOrNull() != null
    }

    companion object {
        const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."
        const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."

        const val MIN_ROUND_NUMBER = 1
    }
}
