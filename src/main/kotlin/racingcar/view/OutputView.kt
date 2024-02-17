package racingcar.view

class OutputView {
    fun printCarNamesGuide() = println(REQUEST_CAR_NAMES_GUIDE)

    fun printRoundNumberGuide() = println(REQUEST_ROUND_NUMBER_GUIDE)

    fun printResultHeader() = println(EXECUTION_RESULT)

    fun printRaceResult(
        name: String,
        position: Int,
    ) = println("$name : ${DASH.repeat(position)}")

    fun printNewLine() = println()

    fun printWinner(winners: List<String>) = println("$FINAL_WINNER${winners.joinToString(COMMA)}")

    companion object {
        private const val REQUEST_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val REQUEST_ROUND_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?"
        private const val EXECUTION_RESULT = "실행 결과"
        private const val FINAL_WINNER = "최종 우승자: "

        private const val DASH = "-"
        private const val COMMA = ", "
    }
}
