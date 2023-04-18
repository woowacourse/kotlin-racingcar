package racingCar.controller

import racingCar.domain.*
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
            outputView.printScoreBoard(cars)
        }

        finish(cars)
    }

    private fun finish(cars: Cars) {
        outputView.printWinners(cars)
    }

    private fun createCars(): Cars {
        val readCarNames: List<String> = inputView.readCarNames()

        return Cars(readCarNames.map { Car(Name(it), RandomNumberGenerator()) }.toList())
    }

    private fun createCount(): Count {
        return Count(inputView.readTryCount())
    }
}
