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

    fun printErrorMessage(message: String?) = println(message)

    companion object {
        const val REQUEST_CAR_NAMES_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val REQUEST_ROUND_NUMBER_GUIDE = "시도할 횟수는 몇 회인가요?"
        const val EXECUTION_RESULT = "실행 결과"
        const val FINAL_WINNER = "최종 우승자: "

        const val DASH = "-"
        const val COMMA = ", "
    }
}
