package view

import domain.Car

object OutputView {
    fun printResult(result: String) {
        println()
        println(MESSAGE_OUTPUT_RESULT_HEADER)
        println(result)
    }

    fun printWinner(winners: List<Car>) {
        println(MESSAGE_OUTPUT_WINNER_PREFIX + winners.joinToString(WINNER_OUTPUT_SEPARATOR) { it.name })
    }

    fun promptCarNamesInput() {
        println(MESSAGE_ENTER_CAR_NAMES)
    }

    fun promptRoundsInput() {
        println(MESSAGE_ENTER_ROUNDS_NUMBER)
    }

    private const val WINNER_OUTPUT_SEPARATOR = ", "

    private const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MESSAGE_ENTER_ROUNDS_NUMBER = "시도할 횟수는 몇 회인가요?"
    private const val MESSAGE_OUTPUT_RESULT_HEADER = "실행 결과"
    private const val MESSAGE_OUTPUT_WINNER_PREFIX = "최종 우승자: "
}
