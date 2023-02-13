package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView
import racing.view.UI

class RacingCarController {

    fun startRace() {
        val carNames = getCarNames()
        val cars: List<Car> = RacingGame.getCars(carNames)
        val moveTimes = getMoveTimes()
        printResult(cars, moveTimes)
    }

    private fun getCarNames(): List<String> {
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
            RacingGame.moveCars(cars)
            OutputView.printCurrentPosition(cars)
        }
        OutputView.printWinners(RacingGame.getWinnerNames(cars))
    }
}
