package racingcar.view

import racingcar.domain.RacingCar

class OutputView {
    fun printGettingCarsName() {
        println(INPUT_CARS_NAME)
    }

    fun printGettingRoundCount() {
        println(INPUT_ROUND_COUNT)
    }

    fun printResult() {
        println(OUTPUT_RESULT)
    }

    fun printEachRound(cars: List<RacingCar>) {
        cars.forEach { println(it.toString()) }
        println()
    }

    fun printWinner(winner: List<String>) {
        println("$OUTPUT_WINNER${winner.joinToString(separator = ", ")}")
    }

    companion object {
        const val INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

        const val OUTPUT_RESULT = "\n실행 결과"
        const val OUTPUT_WINNER = "최종 우승자: "
    }
}
