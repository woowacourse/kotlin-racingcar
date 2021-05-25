package racingcar.view

object OutputView {

    private const val PROGRESS_BAR = "-"

    fun printRaceInitMessage() {
        println("실행 결과")
    }

    fun printStatus(result: LinkedHashMap<String, Int>) {
        for (name in result.keys) {
            val position = result[name] ?: 0
            val processBar = PROGRESS_BAR.repeat(position)
            println("$name : $processBar")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString()
        println("$winnerNames 가 최종 우승했습니다.")
    }
}
