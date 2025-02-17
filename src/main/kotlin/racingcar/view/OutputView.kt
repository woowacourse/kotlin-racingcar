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
        println()
    }

    fun printWinners(winners: List<String>) {
        println(WINNERS_FORMAT.format(winners.joinToString(COMMA)))
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
        const val WINNERS_FORMAT = "최종 우승자: %s"
        const val COMMA = ", "
    }
}
