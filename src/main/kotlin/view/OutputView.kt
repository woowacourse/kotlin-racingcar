package view

import model.Car
import model.Cars
class OutputView {

    fun outputCarNames() {
        println(INPUT_CAR_NAME)
    }

    fun outputTryNumber() {
        println(INPUT_TRY_NUMBER)
    }

    fun outputResults() {
        println()
        println(OUTPUT_RESULT)
    }

    fun outputErrorMessage(error: String) {
        println(error)
    }

    fun outputResult(cars: Cars) {
        cars.cars.forEach {
            outputCarResult(it)
        }
        println()
    }

    fun outputCarResult(car: Car) {
        print(car.name + CAR_SEPARATE_MARK)
        repeat(car.position) { print(CAR_MOVE_MARK) }
        println()
    }

    fun outputWinners(winners: List<String>) {
        when {
            winners.size == 0 -> println(OUTPUT_NO_EXIST_WINNER)
            else -> println(OUTPUT_WINNER + winners.joinToString(separator = WINNERS_SEPARATE_MARK))
        }
    }

    companion object {
        const val INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_TRY_NUMBER = "시도할 횟수는 몇 회인가요?"
        const val OUTPUT_RESULT = "실행 결과"
        const val OUTPUT_WINNER = "최종 우승자: "
        const val OUTPUT_NO_EXIST_WINNER = "우승자가 없습니다."
        const val CAR_SEPARATE_MARK = " : "
        const val CAR_MOVE_MARK = "-"
        const val WINNERS_SEPARATE_MARK = ", "
    }
}
