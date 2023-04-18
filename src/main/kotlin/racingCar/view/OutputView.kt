package racingCar.view

import racingCar.domain.Car
import racingCar.domain.Cars

class OutputView {

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printScoreBoard(cars: Cars) {
        cars.cars.forEach { car: Car -> println("${car.name.name} : ${"-".repeat(car.position)}") }
        println()
    }

    fun printWinners(cars: Cars) {
        println("최종 우승자: ${cars.getWinner().joinToString(", ") { it.name }}")
    }
}
