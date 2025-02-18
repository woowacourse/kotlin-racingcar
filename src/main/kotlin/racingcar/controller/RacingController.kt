package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val racingGame: RacingGame,
) {
    fun run() {
        prepareRacingCar()
        tryRacing()
        printRacingWinner()
    }

    private fun prepareRacingCar() {
        val carNames = InputView.inputCarNames()
        racingGame.generateCars(carNames)
    }

    private fun tryRacing() {
        val racingCount = InputView.inputRacingCount()

        OutputView.printRacingResultHeader()
        racingGame.tryRacing(
            count = racingCount,
            printCurrentCarStep = { currentCarStep ->
                OutputView.print(currentCarStep)
            },
        )
    }

    private fun printRacingWinner() {
        val result = racingGame.calculateWinner()
        OutputView.printWinner(result)
    }
}
