package racingcar.view

class OutputView {
    fun printGameResultMessage() {
        println(GAME_RESULT_MESSAGE)
    }

    fun printRoundResult(roundResult: List<Pair<String, Int>>) {
        roundResult.forEach { result ->
            println(
                ROUND_RESULT_FORMAT.format(
                    result.first,
                    HYPHEN.repeat(result.second),
                ),
            )
        }
    }

    companion object {
        const val GAME_RESULT_MESSAGE = "실행 결과"
        const val ROUND_RESULT_FORMAT = "%s : %s"
        const val HYPHEN = "-"
    }
}
