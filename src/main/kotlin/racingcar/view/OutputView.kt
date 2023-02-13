package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printMessage(message: String) = println(message)

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionAsDash()}")
        }
        println()
    }
}
