package view

import domain.Car

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

    fun printResultMessage() {
        println(RESULT)
    }

    fun printResult(result: List<Car>) {
        result.forEach { car ->
            val eachResult = car.carName + COLON + car.distance
            println(eachResult)
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println(WINNER + winners.joinToString(SEPARATOR))
    }

    fun printErrorMessage(message: String) {
        println(message)
    }
}
