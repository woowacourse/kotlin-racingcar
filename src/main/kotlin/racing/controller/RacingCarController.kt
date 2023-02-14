package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.util.RandomNumberGenerator
import racing.view.InputView
import racing.view.OutputView
import racing.view.UI

class RacingCarController {

    private val randomNumberGenerator = RandomNumberGenerator()

    fun startRace() {
        val cars: List<Car> = getCars()
        val moveTimes: Int = getMoveTimes()
        printResult(cars, moveTimes)
    }

    private fun getCars(): List<Car> {
        UI.printRequestCarNames()
        return InputView.inputCarNames()
    }

    private fun getMoveTimes(): Int {
        UI.printRequestTimes()
        return InputView.inputCount()
    }

    private fun printResult(cars: List<Car>, moveTimes: Int) {
        UI.printResult()
        repeat(moveTimes) {
            val movedCars = RacingGame.moveCars(cars, randomNumberGenerator)
            OutputView.printCurrentPosition(movedCars)
        }
        OutputView.printWinners(RacingGame.getWinnerNames(cars))
    }
}
