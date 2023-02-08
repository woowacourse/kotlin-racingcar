package view

private const val ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val ENTER_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
private const val RESULT = "실행 결과"
private const val COLON = " : "
private const val WINNER = "최종 우승자: "
private const val SEPARATOR = ", "

class OutputView {
    fun printEnterCarName() {
        println(ENTER_CAR_NAME)
    }

    fun printEnterTryCount() {
        println(ENTER_TRY_COUNT)
    }

    fun printResult(result: Map<String, String>) {
        println(RESULT)
        result.forEach { entry ->
            val eachResult = entry.key + COLON + entry.value
            println(eachResult)
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println(WINNER + winners.joinToString(SEPARATOR))
    }
}
