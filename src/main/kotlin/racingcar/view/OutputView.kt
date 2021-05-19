package racingcar.view

import racingcar.model.Cars

object OutputView {

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
}
