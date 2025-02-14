package view

object OutputView {
    fun printRaceState(result: String) {
        println(result)
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(WINNER_DELIMITER)}")
    }

    private const val WINNER_DELIMITER = ", "
}
