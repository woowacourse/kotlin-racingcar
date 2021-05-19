package racingcar.input

import racingcar.domain.car.Car
import kotlin.streams.toList

class OutputView {

    fun printCars(cars: List<Car>) {
        cars.stream()
            .forEach { car -> printCar(car) }
        println()
    }

    private fun printCar(car: Car) {
        val name = car.name()
        val positionBar = positionBar(car.position())

        print("$name : $positionBar")
    }

    private fun positionBar(position: Int): String {
        val bar = StringBuilder()
        for (i in 0 until position) {
            bar.append("-")
        }
        return bar.toString()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.stream()
            .map { car -> car.name() }
            .toList()
            .joinToString { "," }

        println(winnerNames + "가 최종 우승하였습니다.")
    }

    fun printResult() {
        println("실행 결과")
    }
}