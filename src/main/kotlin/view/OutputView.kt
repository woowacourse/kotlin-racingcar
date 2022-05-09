package view

import domain.Car
import vo.Name

object OutputView {

    private const val DELIMITER_BETWEEN_NAME_AND_POSITION = ":"
    private const val POSITION_INDICATOR = "-"
    private const val WINNER_DELIMITER = ","

    fun printInputCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printInputNumberOfGames() {
        println("시도할 횟수는 몇회인가요?")
    }

    fun printException(message: String?) {
        println("[ERROR] $message")
    }

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printGameResult(cars: List<Car>) {
        cars.forEach { println(visualizeCarPosition(it)) }
        println()
    }

    private fun visualizeCarPosition(car: Car): String {
        return car.name.name + DELIMITER_BETWEEN_NAME_AND_POSITION + POSITION_INDICATOR.repeat(car.position.position)
    }

    fun printWinners(winners: List<Name>) {
        val winnerNames = winners.joinToString(WINNER_DELIMITER) { it.name }
        println("$winnerNames 가 최종 우승했습니다.")
    }
}
