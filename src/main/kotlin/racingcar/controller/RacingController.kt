package racingcar.controller

import racingcar.model.RacingGame
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private var racingGame: RacingGame

    init {
        val randomNumberGeneratorImpl = RandomNumberGenerator()
        racingGame = RacingGame(randomNumberGeneratorImpl)
    }

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
