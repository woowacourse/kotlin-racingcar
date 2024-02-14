package racingcar.view

import racingcar.model.Car

class OutputView {

    fun printResultTitle() = println(MESSAGE_ROUND_RESULT)

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car -> println(car) }
        println()
    }

    companion object {
        const val MESSAGE_ROUND_RESULT = "\n실행 결과"
    }
}