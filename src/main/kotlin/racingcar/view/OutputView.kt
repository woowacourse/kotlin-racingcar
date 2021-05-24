package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

fun printResults(racingResult: List<Cars>) {
    println("실행 결과")
    for (cars in racingResult) {
        printResult(cars)
    }
}

private fun printResult(cars: Cars) {
    for (car in cars.cars) {
        println("${car.name} : ${"-".repeat(car.position)}")
    }
    println()
}

fun printWinners(winners: List<Car>) {
    val winnerNames = winners.map { it.name }
        .toList()

    println("${winnerNames.joinToString(",")}가 최종 우승했습니다.")
}
