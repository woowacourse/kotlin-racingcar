package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCars
import racingcar.view.input.InputView
import racingcar.view.output.OutputView

class CarRacing(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun play() {
        val cars = getCars()
        val racingCars = RacingCars(cars)

        race(racingCars)
        printRacerResult(racingCars)
    }

    private fun getCars(): List<Car> {
        val carNames = inputView.askCarNames()
        val cars = carNames.map { carName -> Car(carName) }

        return cars
    }

    private fun race(racingCars: RacingCars) {
        val attempts = inputView.askNumberOfAttempts()
        outputView.printExecutionResult()
        repeat(attempts) {
            racingCars.race()
            outputView.printProgress(racingCars.cars)
        }
    }

    private fun printRacerResult(racingCars: RacingCars) {
        val winners = racingCars.findWinner()
        outputView.printLastWinner(winners)
    }
}
