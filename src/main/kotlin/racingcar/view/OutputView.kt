package racingcar.view

class OutputView {
    fun printGameResultMessage() {
        println(GAME_RESULT_MESSAGE)
    }

    fun printRoundResult(roundResult: String) {
        println(roundResult)
        println()
    }

    fun printWinners(winners: List<String>) {
        println(WINNERS_FORMAT.format(winners.joinToString(COMMA)))
    }

    fun printErrorMessage(message: String?) {
        println(message)
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
        const val WINNERS_FORMAT = "최종 우승자: %s"
        const val COMMA = ", "
    }
}
