package racing.controller

import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView
import racing.view.UI

class RacingCarController {

    init {
        val carNames = getCarNames()
        RacingGame.registerCars(carNames)
    }

    fun startRace() {
        val moveTimes = getMoveTimes()
        printResult(moveTimes)
    }

    private fun getCarNames(): List<String> {
        UI.printRequestCarNames()
        return InputView.inputCarNames()
    }

    private fun getMoveTimes(): Int {
        UI.printRequestTimes()
        return InputView.inputCount()
    }

    private fun printResult(moveTimes: Int) {
        UI.printResult()
        repeat(moveTimes) {
            RacingGame.moveCars()
            OutputView.printCurrentPosition(RacingGame.cars)
        }
        OutputView.printWinners(RacingGame.getWinnerNames())
    }
}
