package racingcar.view

import racingcar.domain.Car

class OutputView {

    fun printResult() {
        println("실행결과")
    }

    fun printRoundResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${printPosition(car)}")
        }
        println()
    }

    private fun printPosition(car: Car) = "-".repeat(car.position.value)

    fun printWinners(cars: List<Car>) {
        println("최종 우승자: ${cars.joinToString(",") { it.name.value }}")
    }
}
