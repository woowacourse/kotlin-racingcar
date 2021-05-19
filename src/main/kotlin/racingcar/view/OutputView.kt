package racingcar.view

object OutputView {

    private const val PROGRESS_BAR = "-"

    fun printRaceInitMessage() {
        println("실행 결과")
    }

    fun printStatus(result: LinkedHashMap<String, Int>) {
        for (name in result.keys) {
            val position = result[name]!!
            val processBar = PROGRESS_BAR.repeat(position)
            println("$name : $processBar")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println(winners.joinToString() + "가 최종 우승했습니다.")
    }
}