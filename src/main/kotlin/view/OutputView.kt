package view

class OutputView {

    fun printCar() = println(INPUT_CAR_NAMES_MESSAGE)
    fun printTryCount() = println(INPUT_TRY_COUNT_MESSAGE)
    fun printRoundResult(roundResult: String) = println(roundResult)
    fun printWinner(winners: List<String>) {
        var output = "최종 우승자: "
        winners.forEach { name ->
            output += "$name, "
        }
        println(output.substring(0, output.length - 2))
    }

    fun printRunResultMessage() = println("\n$RUN_RESULT_MESSAGE")

    companion object {
        const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val RUN_RESULT_MESSAGE = "실행 결과"
    }
}
