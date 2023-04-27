package racingCar.view

import racingCar.domain.Car
import racingCar.domain.Cars

class OutputView {

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printCurrentCarPosition(cars: Cars) {
        cars.cars.forEach { car: Car -> println("${car.name.name} : ${CONCAT_DELIMITER.repeat(car.position)}") }
        println()
    }

    fun printWinners(cars: Cars) {
        println("최종 우승자: ${cars.getWinner().joinToString(SEPARATOR) { it.name }}")
    }

    fun printErrorMessage(e: String?) {
        println(e)
    }

    companion object {
        private const val CONCAT_DELIMITER: String = "-"
        private const val SEPARATOR: String = ", "
    }
}
