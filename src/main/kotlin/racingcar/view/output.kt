package racingcar.view

import racingcar.model.Car

fun printRunMenu() {
    println("실행 결과")
}

fun printProgress(cars: List<Car>) {
    for (car in cars) {
        val progressBar = "-".repeat(car.position)
        println("${car.name} : $progressBar")
    }
    println()
}

fun printWinners(winners: List<String>) {
    print("최종 우승자 : ${winners.joinToString(", ")}")
}