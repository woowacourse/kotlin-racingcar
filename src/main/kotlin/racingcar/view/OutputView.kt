package racingcar.view

import racingcar.utils.Constants.COMMA
import racingcar.utils.Constants.RUNNING_RESULT_MESSAGE
import racingcar.utils.Constants.WINNERS_MESSAGE

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
}
