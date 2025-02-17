package view

import model.Car

object OutputView {
    fun printResult(result: String) {
        println()
        println(MESSAGE_OUTPUT_RESULT_HEADER)
        println(result)
    }

    fun printWinner(winners: List<Car>) {
        println(MESSAGE_OUTPUT_WINNER_PREFIX + winners.joinToString(WINNER_OUTPUT_SEPARATOR) { it.name })
    }

    fun printMessage(prompt: String) {
        println(prompt)
    }

    private const val WINNER_OUTPUT_SEPARATOR = ", "

    private const val MESSAGE_OUTPUT_RESULT_HEADER = "실행 결과"
    private const val MESSAGE_OUTPUT_WINNER_PREFIX = "최종 우승자: "
}
