package racingcar.input

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import kotlin.streams.toList

class OutputView {

    fun printCars(cars: Cars) {
        cars.asList().stream()
            .forEach { printCar(it) }
        println()
    }

    private fun printCar(car: Car) {
        val name = car.name()
        val positionBar = positionBar(car.position())

        println("$name : $positionBar")
    }

    private fun positionBar(position: Int): String {
        val bar = StringBuilder()
        for (i in 0 until position) {
            bar.append("-")
        }
        return bar.toString()
    }

    fun printWinners(winners: Cars) {
        val winnerCars = winners.asList()
        val winnerNames = winnerCars.stream()
            .map { it.name() }
            .toList()
            .joinToString(",")

        println(winnerNames + "가 최종 우승하였습니다.")
    }

    fun printResult() {
        println("실행 결과")
    }
}