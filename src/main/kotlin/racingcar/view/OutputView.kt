package racingcar.view

object OutputView {

    private const val PROGRESS_BAR = "-"

    fun printRaceInitMessage() {
        println("실행 결과")
    }

    fun printStatus(pairs: List<Pair<String, Int>>) {
        pairs.forEach { pair ->
            val position = pair.second
            val processBar = PROGRESS_BAR.repeat(position)
            println("${pair.first} : $processBar")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString()
        println("$winnerNames 가 최종 우승했습니다.")
    }
}
