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
        val carNames: List<String> = inputView.inputCar()
        val cars = carNames.map { Car(it) }
        val count = inputView.inputTry()

        run(count, cars)
    }

    fun run(
        count: Int,
        cars: List<Car>,
    ) {
        outputView.printRunMenu()

        repeat(count) {
            racing.racingCars(cars)
            outputView.printProgress(cars)
        }

        val winners = racing.findWinnerNames(cars)
        outputView.printWinners(winners)
    }
}
