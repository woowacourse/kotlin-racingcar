package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    fun playGame() {
        val carNames = InputView.inputCarNames().map { Car(it) }
        val laps = InputView.inputLaps()

        val racingGame = RacingGame(Cars(carNames), laps)
        racingGame.race()

        OutputView.printHistory(racingGame.history())
        OutputView.printWinners(racingGame.winner())
    }
}