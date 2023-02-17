package racingcar.view

import racingcar.domain.RacingCar

object OutputView {
    private const val INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

    private const val OUTPUT_RESULT = "\n실행 결과"
    private const val OUTPUT_WINNER = "최종 우승자: "
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
}
