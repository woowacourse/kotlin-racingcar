package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView
import racing.view.UI

class RacingCarController {

    private val racingGame: RacingGame

    init {
        val cars = getCars()
        racingGame = RacingGame(cars)
    }

    fun startRace() {
        val moveTimes = getMoveTimes()
        printResult(moveTimes)
    }

    private fun getCars(): List<Car> {
        UI.printRequestCarNames()
        return InputView.inputCarNames().map { Car(it) }
    }

    private fun getMoveTimes(): Int {
        UI.printRequestTimes()
        return InputView.inputCount()
    }

    private fun printResult(moveTimes: Int) {
        UI.printResult()
        repeat(moveTimes) {
            racingGame.moveCars()
            OutputView.printCurrentPosition(racingGame.cars)
        }
        OutputView.printWinners(racingGame.getWinnerNames())
    }
}
