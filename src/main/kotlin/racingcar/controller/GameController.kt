package racingcar.controller

import racingcar.model.Car
import racingcar.model.Racing
import racingcar.view.Input
import racingcar.view.Output

class GameController {
    val inputView = Input()
    val outputView = Output()
    val racing = Racing()

    fun game() {
        val carNames = inputCarName()
        var cars = mutableListOf<Car>()
        val count = inputTryCnt()

        carNames.split(",").forEach { cars.add(Car(it)) }
        run(count, cars)
    }

    fun inputCarName(): String {
        val carNames = inputView.inputCar()
        return carNames
    }

    fun inputTryCnt(): Int {
        var count = 0
        try {
            count = inputView.inputTry()
        } catch (e: Exception) {
            println(e)
            count = inputTryCnt()
        }
        return count
    }

    fun run(
        count: Int,
        cars: MutableList<Car>,
    ) {
        outputView.printRunMenu()

        for (i in 1..count) {
            racing.racingCars(cars)
            outputView.printProgress(cars)
        }

        val winners = racing.findWinnerNames(cars)
        outputView.printWinners(winners)
    }
}
