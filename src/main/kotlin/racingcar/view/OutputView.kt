package racingcar.view

import racingcar.model.RoundResult

class OutputView {
    fun printGameResultMessage() {
        println(GAME_RESULT_MESSAGE)
    }

    fun printRoundResult(roundResult: List<RoundResult>) {
        roundResult.forEach { result ->
            println(result.toString())
        }
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
    }
}
