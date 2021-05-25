package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

fun printResults(pair: Pair<List<Cars>, List<Car>>) {
    println("실행 결과")
    for (cars in pair.first) {
        printResult(cars)
    }

    val winnerNames = pair.second.map { it.name }
    println("${winnerNames.joinToString(",")}가 최종 우승했습니다.")
}

private fun printResult(cars: Cars) {
    cars.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
}

