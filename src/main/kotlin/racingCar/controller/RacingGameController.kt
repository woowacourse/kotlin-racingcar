package racingCar.controller

import racingCar.domain.Car
import racingCar.domain.Cars
import racingCar.domain.Count
import racingCar.domain.Name
import racingCar.domain.RandomNumberGenerator
import racingCar.view.InputView
import racingCar.view.OutputView

class RacingGameController(private val inputView: InputView, private val outputView: OutputView) {

    fun start() {
        val cars: Cars = createCars()
        val count: Count = createCount()

        play(count, cars)
    }

    private fun play(count: Count, cars: Cars) {
        outputView.printResultMessage()

        while (count.isOpportunity()) {
            cars.moveAll()
            count.deduct()
            outputView.printCurrentCarPosition(cars)
        }

        finish(cars)
    }

    private fun finish(cars: Cars) {
        outputView.printWinners(cars)
    }

    private fun createCars(): Cars {
        return repeatInput { Cars(inputView.readCarNames().map { Car(Name(it), RandomNumberGenerator()) }.toList()) }
    }

    private fun createCount(): Count {
        return repeatInput { Count(inputView.readTryCount()) }
    }

    private fun <T> repeatInput(input: () -> T): T {
        return try {
            input()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            repeatInput(input)
        }
    }
}
