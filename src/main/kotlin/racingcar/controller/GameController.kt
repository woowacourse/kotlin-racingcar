package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.input.InputView
import racingcar.input.OutputView
import java.util.*

class GameController(scanner: Scanner) {
    private val inputView = InputView(scanner)
    private val outputView = OutputView()

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