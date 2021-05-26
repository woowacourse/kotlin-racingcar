package racingcar.input

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

object OutputView {
    fun printCars(cars: Cars) {
        cars.cars.forEach { printCar(it) }
        println()
    }

    private fun printCar(car: Car) {
        val name = car.name.value
        val positionBar = positionBar(car.position())

        println("$name : $positionBar")
    }

    private fun positionBar(position: Int): String {
        val bar = StringBuilder()
        repeat(position) {
            bar.append("-")
        }
        return bar.toString()
    }

    fun printWinners(winners: Cars) {
        val winnerNames = winners.cars.joinToString(",") { it.name.value }

        println(winnerNames + "가 최종 우승하였습니다.")
    }

    fun printResult() {
        println("실행 결과")
    }
}