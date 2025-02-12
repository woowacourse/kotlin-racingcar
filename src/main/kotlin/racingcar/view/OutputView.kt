package racingcar.view

class OutputView {
    fun printRoundResult(
        carNames: List<String>,
        moves: List<List<String>>,
        tryCount: Int,
    ) {
        println("\n실행 결과")
        for (i in 0 until tryCount) {
            carNames.forEachIndexed { index, carName ->
                println("$carName : ${moves[index].take(i + 1).joinToString("")}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }
}
