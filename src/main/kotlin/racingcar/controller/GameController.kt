package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.input.InputView
import racingcar.input.OutputView

class GameController(inputView: InputView, outputView: OutputView) {

    private val inputView = inputView
    private val outputView = outputView

    fun playGame() {
        val racingGame = RacingGame(inputView.inputCarNames(), inputView.inputLaps())

        outputView.printResult()
        while (!racingGame.isEnd()) {
            racingGame.race()
            outputView.printCars(racingGame.result())
        }

        outputView.printWinners(racingGame.winner())
    }
}