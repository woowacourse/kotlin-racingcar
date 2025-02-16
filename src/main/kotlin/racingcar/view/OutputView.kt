package racingcar.view

class OutputView {
    fun printRoundResult(
        carNames: List<String>,
        moves: List<List<String>>,
        tryCount: Int,
    ) {
        println(RUNNING_RESULT_MESSAGE)
        for (i in 0 until tryCount) {
            carNames.forEachIndexed { index, carName ->
                println("$carName : ${moves[index].take(i + 1).joinToString("")}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("$WINNERS_MESSAGE ${winners.joinToString("$COMMA ")}")
    }

    companion object {
        private const val RUNNING_RESULT_MESSAGE = "\n실행 결과"
        private const val WINNERS_MESSAGE = "최종 우승자:"
        private const val COMMA = ","
    }
}
