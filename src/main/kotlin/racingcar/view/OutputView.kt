package racingcar.view

import racingcar.model.Car
import racingcar.util.Message

class OutputView {
    fun outputRoundResults(cars: List<Car>) {
        println(Message.RESULT_START)
        cars.forEach { car ->
            println(Message.ROUND_RESULT.format(car.getName(), PROGRESS_BAR.repeat(car.getStep())))
        }
    }

    companion object {
        const val PROGRESS_BAR = "-"
    }
}
