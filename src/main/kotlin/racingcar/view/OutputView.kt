package racingcar.view

class OutputView {
    fun printRoundResult(
        carNames: List<String>,
        roundPositions: List<List<Int>>,
    ) {
        println(RUNNING_RESULT_MESSAGE)
        roundPositions.forEach { positions ->
            carNames.forEachIndexed { index, carName ->
                println("$carName : ${printMoves(positions[index])}")
            }
            println()
        }
    }

    private fun printMoves(position: Int): String {
        return MOVE.repeat(position)
    }

    fun printWinners(winners: List<String>) {
        println("$WINNERS_MESSAGE ${winners.joinToString("$COMMA ")}")
    }

    companion object {
        private const val RUNNING_RESULT_MESSAGE = "\n실행 결과"
        private const val WINNERS_MESSAGE = "최종 우승자:"
        private const val COMMA = ","
        private const val MOVE = "-"
    }
}
