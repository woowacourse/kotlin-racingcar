package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarHandler
import racingcar.view.input.InputView
import racingcar.view.output.OutputView

class CarRacing(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var carHandler: CarHandler

    fun play() {
        val cars = getCars()
        carHandler = CarHandler(cars)
        race(cars)
        printRacerResult()
    }

    private fun getCars(): List<Car> {
        outputView.enterCarNames()
        val carNames = inputView.askCarNames()

        return carNames.map { carName -> Car(carName) }
    }

    private fun race(cars: List<Car>) {
        outputView.enterNumberOfAttempts()
        val attempts = inputView.askNumberOfAttempts()
        outputView.printExecutionResult()
        repeat(attempts) {
            carHandler.proceed()
            outputView.printProgress(cars.map { car -> "${car.name}: ${car.position}" })
        }
    }

    private fun printRacerResult() {
        val winners = carHandler.winner()
        outputView.printLastWinner(winners)
    }
}
