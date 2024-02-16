package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingCarGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var racingCarGame: RacingCarGame

    fun run() {
        val carNames = inputView.getCarNames()
        val cars = carNames.map { name -> Car(name) }
        val round = inputView.getRoundCount()

        racingCarGame = RacingCarGame(cars)
        startRound(round)
        getWinner()
    }

    private fun startRound(round: Int) {
        outputView.printResultTitle()
        repeat(round) {
            val result = racingCarGame.race()
            outputView.printRoundResult(result)
        }
    }

    private fun getWinner() {
        val winners = racingCarGame.findWinners()
        outputView.printWinners(winners)
    }
}
