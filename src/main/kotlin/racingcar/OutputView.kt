package racingcar

class OutputView {
    fun printRoundResult(carNames: List<String>, moves: List<List<String>>, tryCount: Int) {
        for (i in 0 until tryCount) {
            carNames.forEachIndexed { index, carName ->
                println("$carName  : ${moves[index].take(i + 1).joinToString("")}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println(winners.joinToString(", "))
    }
}