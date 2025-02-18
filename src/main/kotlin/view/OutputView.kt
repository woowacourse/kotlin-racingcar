package view

import model.RaceResult

object OutputView {
    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printRaceResult(raceResult: RaceResult) {
        raceResult.carStates.forEach {
            println("${it.name} : ${FORWARD_SIGN.repeat(it.position)}") // 위치에 맞게 "-" 출력
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(WINNER_DELIMITER)}")
    }

    private const val RESULT_MESSAGE = "\n실행 결과"
    private const val WINNER_DELIMITER = ", "
    private const val FORWARD_SIGN = "-"
}
